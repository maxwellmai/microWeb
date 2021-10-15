package pri.maxwell.microweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pri.maxwell.microweb.service.HomeService;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author: Mai
 * @Date: 2021/10/15/14:36
 * @Description: 启动一个 Mock 的 Spring 环境，不会执行真正的后端逻辑，而是走的 Mock 逻辑。适合进行单元测试。可以使用 @WebMvcTest(XxController.class) 来快速测试单个 controller
 */
// @WebMvcTest 注解，是包含了 @AutoConfigureMockMvc 的组合注解
@WebMvcTest
public class WebLayerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private HomeService service;

    @Test
    public void test1() throws Exception {
        when(service.sayHi()).thenReturn("Hi!");
        this.mockMvc.perform(get("/test").param("id", "1").param("name", "hello"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("hello!")));
    }

}
