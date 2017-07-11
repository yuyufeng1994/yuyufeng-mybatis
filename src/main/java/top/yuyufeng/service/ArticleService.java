package top.yuyufeng.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.yuyufeng.dao.ArticleInfoMapper;
import top.yuyufeng.entity.ArticleInfo;

import java.util.List;

/**
 * Created by yuyufeng on 2017/6/7.
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    public int add(ArticleInfo articleInfo) {
        return articleInfoMapper.insertSelective(articleInfo);
    }

    public int update(ArticleInfo articleInfo) {
        if (StringUtils.isEmpty(articleInfo.getArticleId())) {
            return articleInfoMapper.insertSelective(articleInfo);
        }
        return articleInfoMapper.updateByPrimaryKeySelective(articleInfo);
    }

    public ArticleInfo getArticle(Long articleId) {
        return articleInfoMapper.selectByPrimaryKey(articleId);
    }

    public PageInfo<ArticleInfo> queryPageOrderByTime(int i, int i1) {

        PageHelper.startPage(i, i1, "article_time desc");
        List<ArticleInfo> list = articleInfoMapper.queryList();
        PageInfo<ArticleInfo> page = new PageInfo<ArticleInfo>(list, 8);
        return page;
    }

    public int delArticle(Long articleId) {
        return articleInfoMapper.deleteByPrimaryKey(articleId);
    }
}
