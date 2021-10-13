package pri.maxwell.microweb.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pri.maxwell.microweb.MicroWebApplication;

/**
 * @Author: Mai
 * @Date: 2021/10/13/17:14
 * @Description:
 */
@RestController
public class HomeController {

    private static Logger log = LogManager.getLogger(MicroWebApplication.class);

    @GetMapping("/")
    public String home() {
        log.info(123);
        log.warn(456);
        log.error(789);
        return "hello world!";
    }
}
