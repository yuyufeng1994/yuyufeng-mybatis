package top.yuyufeng.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.yuyufeng.entity.ArticleInfo;
import top.yuyufeng.service.ArticleService;
import top.yuyufeng.vo.MessageVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * Created by yuyufeng on 2017/6/7.
 */
@Controller
@RequestMapping("/admin/article")
public class ArticleController {

    @Resource(name = "urlMap")
    private Map<String, String> urlMap;

    @Autowired
    private ArticleService articleService;


    @RequestMapping("/doEdit")
    public String toEdit(ArticleInfo articleInfo, Model model) {
        articleInfo.setArticleTime(new Date());
        articleService.update(articleInfo);
        model.addAttribute("messageVo", new MessageVo("修改成功！", urlMap.get("appServer") + "/article/" + articleInfo.getArticleId(), "立即查看"));
        return "admin/message";
    }


    @RequestMapping("/edit/{articleId}")
    public String toEdit(@PathVariable("articleId") Long articleId, Model model) {
        ArticleInfo articleInfo = articleService.getArticle(articleId);
        model.addAttribute("article", articleInfo);
        return "admin/article/edit";
    }

    @RequestMapping("/new")
    public String toNew() {
        return "admin/article/new";
    }

    @RequestMapping("/publish")
    public String doPublish(ArticleInfo articleInfo,Model model) {
        articleInfo.setArticleTime(new Date());
        articleService.add(articleInfo);
        model.addAttribute("messageVo", new MessageVo("发表成功！", urlMap.get("appServer") + "/article/" + articleInfo.getArticleId(), "立即查看"));
        return "admin/message";
    }
}
