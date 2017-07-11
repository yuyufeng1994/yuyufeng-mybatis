package dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.yuyufeng.dao.ArticleCatalogMapper;

/**
 * Created by yuyufeng on 2017/7/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class CatalogMapperTest {
    @Autowired
    private ArticleCatalogMapper articleCatalogMapper;
    @Test
    public void test(){
        System.out.println(articleCatalogMapper.selectByPrimaryKey(1l));
    }
}

