package pri.maxwell.microweb.framework;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Author: Mai
 * @Date: 2021/10/14/17:45
 * @Description: 统一封装controller返回的string和object数据
 */
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    final Logger logger = LoggerFactory.getLogger(ResponseAdvice.class);
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 如果 Controller 直接返回 String 的话，SpringBoot 是直接返回，故我们需要手动转换成 json
        if (body instanceof String) {
            return objectMapper.writeValueAsString(ResultData.ok(body));
        }
        if (body instanceof ResultData) {
            return body;
        }
        return ResultData.ok(body);
    }
}
