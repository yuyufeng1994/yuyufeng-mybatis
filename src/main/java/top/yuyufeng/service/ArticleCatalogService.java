package top.yuyufeng.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yuyufeng.dao.ArticleCatalogMapper;
import top.yuyufeng.entity.ArticleCatalog;

import java.util.List;

/**
 * Created by yuyufeng on 2017/7/11.
 */
@Service
public class ArticleCatalogService {
    @Autowired
    private ArticleCatalogMapper articleCatalogMapper;

    public List<ArticleCatalog> queryArticleCatalogList() {
        return articleCatalogMapper.queryList();
    }
}
