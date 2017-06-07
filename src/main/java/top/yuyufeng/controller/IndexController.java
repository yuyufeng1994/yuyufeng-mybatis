package top.yuyufeng.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.yuyufeng.dao.ArticleInfoMapper;
import top.yuyufeng.entity.ArticleInfo;
import top.yuyufeng.service.ArticleService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by yuyufeng on 2017/6/2.
 */
@Controller
public class IndexController {
    @Resource(name = "urlMap")
    private Map<String, String> urlMap;
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/home")
    public String toHome(Model model) {
        Page<ArticleInfo> page = articleService.queryPageOrderByTime(1,5);
        model.addAttribute("page",page);
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

    @RequestMapping("/article/{articleId}")
    public String toArticle(@PathVariable("articleId") Long articleId, Model model) {
        ArticleInfo articleInfo = articleService.getArticle(articleId);
        if(StringUtils.isEmpty(articleInfo.getArticlePhotoPath())){
            articleInfo.setArticlePhotoPath(urlMap.get("staticServer")+"/static/vendor/cleanblog/img/home-bg.jpg");
        }
        model.addAttribute("article", articleInfo);
        return "index/article";
    }

    @RequestMapping("/list/{pageNo}")
    public String toList(Model model,@PathVariable("pageNo") int pageNo) {
        Page<ArticleInfo> page = articleService.queryPageOrderByTime(pageNo,10);
        model.addAttribute("page",page);
        return "index/list";
    }


}
