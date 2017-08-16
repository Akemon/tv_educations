package application.com.coocaa.Test;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
@EnableAutoConfiguration
public class TestController {
    @RequestMapping("/hhhhh")
    @ResponseBody
    String home23232() {
        return "index";
    }
//
//    @RequestMapping("/hello")
//    String home2() {
//        return "hello world ";
//    }

}