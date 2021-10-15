package pri.maxwell.microweb.framework;

import lombok.Data;

/**
 * @Author: Mai
 * @Date: 2021/10/14/18:06
 * @Description:
 */
@Data
public class ResultData<T> {
    private Integer statusCode;
    private String message;
    private T dataObject;
    private Long timestamp;

    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ResultData<T> ok(T data) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatusCode(100);
        resultData.setMessage("操作成功");
        resultData.setDataObject(data);
        return resultData;
    }

    public static <T> ResultData<T> fail(Integer failCode, String failMessage) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatusCode(failCode);
        resultData.setMessage(failMessage);
        return resultData;
    }
}
