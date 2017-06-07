package top.yuyufeng.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.yuyufeng.entity.ArticleInfo;
import top.yuyufeng.service.ArticleService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by yuyufeng on 2017/6/7.
 */
@Controller
@RequestMapping("/admin/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/new")
    public String toNew() {
        return "admin/article/new";
    }

    @RequestMapping("/publish")
    public String doPublish(ArticleInfo articleInfo) {
        articleInfo.setArticleTime(new Date());

        articleService.add(articleInfo);
        return "admin/article/new";
    }
}
