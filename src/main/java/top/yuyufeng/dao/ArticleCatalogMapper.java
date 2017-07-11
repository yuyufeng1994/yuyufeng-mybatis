package top.yuyufeng.dao;

import top.yuyufeng.entity.ArticleCatalog;

import java.util.List;

public interface ArticleCatalogMapper {
    int deleteByPrimaryKey(Long articleCatalogId);

    int insert(ArticleCatalog record);

    int insertSelective(ArticleCatalog record);

    ArticleCatalog selectByPrimaryKey(Long articleCatalogId);

    int updateByPrimaryKeySelective(ArticleCatalog record);

    int updateByPrimaryKey(ArticleCatalog record);

    List<ArticleCatalog> queryList();
}