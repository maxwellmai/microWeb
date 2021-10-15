package pri.maxwell.microweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;
import pri.maxwell.microweb.controller.HomeController;

// 导入静态类方便方法的快速调用
// 流式断言
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
// mockmvc 相关
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author: Mai
 * @Date: 2021/10/15/11:41
 * @Description: 启动整个真实的 springboot 环境，来进行测试
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class MicroWebApplicationTests {
    @LocalServerPort
    private int port;
    @Autowired
    private HomeController controller;
    @Autowired
    private TestRestTemplate restTemplate;
    // 注释了 @AutoConfigureMockMvc 才能成功注入 MockMvc
    @Autowired
    private MockMvc mockMvc;

    @Test
    void test2() throws Exception {
        this.mockMvc.perform(get("/test").param("id", "-100").param("name", "hello"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, World")));
    }

    @Test
    void test3() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, World")));
    }

}
