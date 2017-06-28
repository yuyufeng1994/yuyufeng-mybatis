package solr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
        Pageable pageable = new PageRequest(0, 10);
        HighlightPage<ArticleCore> page =  articleCoreRepository.findByArticleContent("Java程序员",pageable);
        for (ArticleCore articleCore : page.getContent()) {
            for (HighlightEntry.Highlight highlight : page.getHighlights(articleCore)) {
                System.out.println(highlight.getSnipplets());
            }
        }
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
            System.out.println(articleInfo.getArticleTitle()+" 建立索引成功!");
            Thread.sleep(1000);
        }

    }

    @Test
    public void testDel() {
        articleCoreRepository.delete("change.me");
    }



    @Test
    public void test() {
        Pageable pageable = new PageRequest(0, 10);
        Page<ArticleCore> page = articleCoreRepository.findAll(pageable);
        for (ArticleCore testCore : page.getContent()) {
            System.out.println(testCore.getArticleTitle());
        }
    }
}
