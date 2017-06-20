package top.yuyufeng.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.yuyufeng.vo.MessageVo;

/**
 * Created by yuyufeng on 2017/6/7.
 */
@Controller
@RequestMapping("/admin")
public class AdminIndexController {

    @RequestMapping({"/index","/"})
    public String toIndex() {
        return "admin/index";
    }

    @RequestMapping("/message")
    public String toMessage(String url, String content, String name, Model model) {
        model.addAttribute("messageVo", new MessageVo(content, url, name));
        return "admin/message";
    }
}
