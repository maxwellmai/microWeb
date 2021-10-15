package pri.maxwell.microweb.framework;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: Mai
 * @Date: 2021/10/15/10:08
 * @Description:
 */
@RestControllerAdvice
public class RestControllerExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResultData<String> test2(Exception exception) {
        return ResultData.fail(401, exception.getMessage());
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> test(BindException bindException) {
        return ResultData.fail(400, bindException.getMessage());
    }
}
