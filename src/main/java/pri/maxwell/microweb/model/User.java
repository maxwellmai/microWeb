package pri.maxwell.microweb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author: Mai
 * @Date: 2021/10/14/16:04
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Min(value = 0, message = "id最小为0")
    private Long id;
    @NotNull(message = "用户名不能为空")
    private String name;
}
