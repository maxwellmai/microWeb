package pri.maxwell.microweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Mai
 * @Date: 2021/10/13/17:14
 * @Description:
 */
@RestController
public class HomeController {
    final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/doTestObject")
    public String testObjectReturn() {
        Map<String, Integer> map = new HashMap();
        map.put("qingfen", 16);
        map.put("lantian", 17);
        map.put("baiyun", 18);
        return "new UniformReponseHandler<Map>().sendSuccessResponse(map)";
    }
}
