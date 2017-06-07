package top.yuyufeng.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yuyufeng on 2017/6/7.
 */
@Controller()
@RequestMapping("/admin")
public class AdminIndexController {
    @RequestMapping("/index")
    public String toIndex() {
        return "admin/index";
    }
}
