package pri.maxwell.microweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pri.maxwell.microweb.model.User;

import javax.validation.Valid;

/**
 * @Author: Mai
 * @Date: 2021/10/13/17:14
 * @Description:
 */
@RestController
public class HomeController {
    final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String home(@RequestParam("hello") int id) {
        int i = 9 / id;
        return "hello!" + i;
    }

    @GetMapping("/test")
    public User test(@Valid User user) {
        return user;
    }
}
