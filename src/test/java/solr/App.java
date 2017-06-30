package solr;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.yuyufeng.dao.ArticleInfoMapper;
import top.yuyufeng.entity.ArticleInfo;
import top.yuyufeng.solr.dao.ArticleCoreRepository;
import top.yuyufeng.solr.entity.ArticleCore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuyufeng on 2017/6/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-solr.xml", "classpath:spring/spring-dao.xml"})
public class App {

    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Autowired
    private ArticleCoreRepository articleCoreRepository;

    @Test
    public void testHightLight() {
        Pageable pageable = new PageRequest(2, 5);
        HighlightPage<ArticleCore> highlightPage = articleCoreRepository.findByKeywords("Java程序员", pageable);
        Page<ArticleCore> articleCoreList = new Page<>(1,5);

        for (int i = 0; i < highlightPage.getHighlighted().size(); i++) {
            ArticleCore articleCore = highlightPage.getHighlighted().get(i).getEntity();
            for (HighlightEntry.Highlight highlight : highlightPage.getHighlighted().get(i).getHighlights()) {
                if ("articleTitle".equals(highlight.getField().getName())) {
                    articleCore.setArticleTitle(highlight.getSnipplets().get(0));
                } else if ("articleContent".equals(highlight.getField().getName())) {
                    articleCore.setArticleContent(highlight.getSnipplets().get(0));
                }

            }
            articleCoreList.add(articleCore);
        }
        articleCoreList.setTotal(highlightPage.getTotalElements());

        PageInfo<ArticleCore> pageInfo = new PageInfo<>(articleCoreList,8);
        System.out.println(articleCoreList);
    }


    @Test
    public void testAdd() {
        ArticleInfo articleInfo = articleInfoMapper.selectByPrimaryKey(5l);
        ArticleCore articleCore = new ArticleCore();
        articleCore.setArticleId(articleInfo.getArticleId());
        articleCore.setId(articleInfo.getArticleId() + "");
        articleCore.setArticleTitle(articleInfo.getArticleTitle());
        articleCore.setArticleContent(articleInfo.getArticleContent());
        articleCoreRepository.save(articleCore);
    }

    @Test
    public void testAddList() throws InterruptedException {
        List<ArticleInfo> articleInfos = articleInfoMapper.queryList();
        for (ArticleInfo articleInfo : articleInfos) {

            ArticleCore articleCore = new ArticleCore();
            articleCore.setArticleId(articleInfo.getArticleId());
            articleCore.setId(articleInfo.getArticleId() + "");
            articleCore.setArticleTitle(articleInfo.getArticleTitle());
            articleCore.setArticleContent(articleInfo.getArticleContent());
            articleCoreRepository.save(articleCore);
            System.out.println(articleInfo.getArticleTitle() + " 建立索引成功!");
            Thread.sleep(1000);
        }

    }

    @Test
    public void testDel() {
        articleCoreRepository.delete("change.me");
    }


    @Test
    public void test() {
       /* Pageable pageable = new PageRequest(0, 10);
        Page<ArticleCore> page = articleCoreRepository.findAll(pageable);
        for (ArticleCore testCore : page.getContent()) {
            System.out.println(testCore.getArticleTitle());
        }*/
    }
}
