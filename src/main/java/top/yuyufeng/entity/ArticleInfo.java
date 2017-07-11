package top.yuyufeng.entity;

import java.util.Date;

public class ArticleInfo {
    private Long articleId;

    private String articleTitle;

    private String articleSubtitle;

    private Date articleTime;

    private String articlePhotoPath;

    private Long articleUserId;

    private Long articleCatalogId;

    private String articleContent;

    public ArticleInfo() {
    }

    public ArticleInfo(Long articleId, String articleTitle, String articleSubtitle, Date articleTime, String articlePhotoPath, Long articleUserId, Long articleCatalogId, String articleContent) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleSubtitle = articleSubtitle;
        this.articleTime = articleTime;
        this.articlePhotoPath = articlePhotoPath;
        this.articleUserId = articleUserId;
        this.articleCatalogId = articleCatalogId;
        this.articleContent = articleContent;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleSubtitle() {
        return articleSubtitle;
    }

    public void setArticleSubtitle(String articleSubtitle) {
        this.articleSubtitle = articleSubtitle;
    }

    public Date getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }

    public String getArticlePhotoPath() {
        return articlePhotoPath;
    }

    public void setArticlePhotoPath(String articlePhotoPath) {
        this.articlePhotoPath = articlePhotoPath;
    }

    public Long getArticleUserId() {
        return articleUserId;
    }

    public void setArticleUserId(Long articleUserId) {
        this.articleUserId = articleUserId;
    }

    public Long getArticleCatalogId() {
        return articleCatalogId;
    }

    public void setArticleCatalogId(Long articleCatalogId) {
        this.articleCatalogId = articleCatalogId;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }
}