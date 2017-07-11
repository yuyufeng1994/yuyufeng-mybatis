package top.yuyufeng.entity;

import java.util.Date;

public class ArticleCatalog {
    private Long articleCatalogId;

    private String articleCatalogTitle;

    private String articleCatalogContent;

    private Date updateTime;

    public ArticleCatalog(Long articleCatalogId, String articleCatalogTitle, String articleCatalogContent, Date updateTime) {
        this.articleCatalogId = articleCatalogId;
        this.articleCatalogTitle = articleCatalogTitle;
        this.articleCatalogContent = articleCatalogContent;
        this.updateTime = updateTime;
    }

    public Long getArticleCatalogId() {
        return articleCatalogId;
    }

    public String getArticleCatalogTitle() {
        return articleCatalogTitle;
    }

    public String getArticleCatalogContent() {
        return articleCatalogContent;
    }

    public Date getUpdateTime() {
        return updateTime;
    }
}