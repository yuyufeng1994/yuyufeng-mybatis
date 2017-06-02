package top.yuyufeng.controller;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.yuyufeng.dao.ArticleInfoMapper;
import top.yuyufeng.entity.ArticleInfo;

/**
 * Created by yuyufeng on 2017/6/2.
 */
@Controller
public class IndexController {

    @RequestMapping("/home")
    public String toHome() {
        return "index/home";
    }

    @RequestMapping("/about")
    public String toAbout() {
        return "index/about";
    }

    @RequestMapping("/post")
    public String toPost() {
        return "index/post";
    }

    @RequestMapping("/contact")
    public String toContact() {
        return "index/contact";
    }


}
