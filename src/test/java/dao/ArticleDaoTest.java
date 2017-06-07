package dao;

import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.yuyufeng.dao.ArticleInfoMapper;
import top.yuyufeng.entity.ArticleInfo;

import java.util.List;

/**
 * Created by yuyufeng on 2017/6/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ArticleDaoTest {
    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Test
    public void test(){
        System.out.println("ArticleDaoTest.test");
    }

    @Test
    public void getOne(){
        articleInfoMapper.selectByPrimaryKey(1l);
    }

    @Test
    public void selectList(){
        PageHelper.startPage(1, 3, "article_time desc");
        List<ArticleInfo> list = articleInfoMapper.queryList();
        for (ArticleInfo articleInfo : list) {
            System.out.println(articleInfo);
        }
    }
}
