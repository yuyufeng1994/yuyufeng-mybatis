package top.yuyufeng.dao;

import top.yuyufeng.entity.ArticleInfo;

public interface ArticleInfoMapper {
    int deleteByPrimaryKey(Long articleId);

    int insert(ArticleInfo record);

    int insertSelective(ArticleInfo record);

    ArticleInfo selectByPrimaryKey(Long articleId);

    int updateByPrimaryKeySelective(ArticleInfo record);

    int updateByPrimaryKeyWithBLOBs(ArticleInfo record);

    int updateByPrimaryKey(ArticleInfo record);
}