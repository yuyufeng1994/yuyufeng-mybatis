package top.yuyufeng.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.stereotype.Service;
import top.yuyufeng.dao.ArticleInfoMapper;
import top.yuyufeng.entity.ArticleInfo;
import top.yuyufeng.solr.dao.ArticleCoreRepository;
import top.yuyufeng.solr.entity.ArticleCore;
import top.yuyufeng.utils.HtmlUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuyufeng on 2017/6/30.
 */
@Service
public class ArticleCoreSolrService {

    @Autowired
    private ArticleCoreRepository articleCoreRepository;

    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    /**
     * 对搜索结果的分页查询
     *
     * @param page
     * @param size
     * @param keywords 搜索关键字
     * @return
     */
    public PageInfo<ArticleCore> queryByKeyWords(int page, int size, String keywords) {
        Pageable pageable = new PageRequest(page, size);
        HighlightPage<ArticleCore> highlightPage = articleCoreRepository.findByKeywords(keywords, pageable);
        Page<ArticleCore> articleCoreList = new Page<>(page, size);
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
        PageInfo<ArticleCore> pageInfo = new PageInfo<>(articleCoreList, 8);
        return pageInfo;
    }

    public void save(Long articleId) {
        ArticleInfo articleInfo = articleInfoMapper.selectByPrimaryKey(articleId);
        ArticleCore articleCore = new ArticleCore();
        articleCore.setArticleId(articleInfo.getArticleId());
        articleCore.setId(articleInfo.getArticleId() + "");
        articleCore.setArticleTitle(articleInfo.getArticleTitle());
        articleCore.setArticleContent(HtmlUtils.deleteAllHTMLTag(articleInfo.getArticleContent()));
        articleCoreRepository.save(articleCore);
    }
}
