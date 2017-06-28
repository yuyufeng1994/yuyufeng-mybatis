package top.yuyufeng.solr.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.repository.Highlight;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import top.yuyufeng.solr.entity.ArticleCore;

import java.util.Collection;

/**
 * Created by yuyufeng on 2017/6/28.
 */
public interface ArticleCoreRepository extends SolrCrudRepository<ArticleCore, String> {
    @Query(value = "*:*")//, filters = {"title北京市"}
    Page<ArticleCore> findAll(Pageable page);

    @Highlight(prefix = "<font style='color:red'>", postfix = "</font>")
    HighlightPage<ArticleCore> findByArticleContent(String articleContent, Pageable page);

}
