package top.yuyufeng.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yuyufeng on 2017/6/5.
 */
@Controller
public class TestController {
    @RequestMapping("/test")
    public String test(String test, HttpServletRequest request) {
        System.out.println(test);
        return "index";
    }

    @RequestMapping("/upload")
    public String toHome() {
        return "test/upload";
    }
}
