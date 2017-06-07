package top.yuyufeng.entity;

import java.util.Date;

public class ArticleInfo {
    private Long articleId;

    private String articleTitle;

    private String articleSubtitle;

    private Date articleTime;

    private String articlePhotoPath;

    private String articleContent;

    public ArticleInfo(Long articleId, String articleTitle, String articleSubtitle, Date articleTime, String articlePhotoPath, String articleContent) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleSubtitle = articleSubtitle;
        this.articleTime = articleTime;
        this.articlePhotoPath = articlePhotoPath;
        this.articleContent = articleContent;
    }

    public ArticleInfo() {
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public void setArticleSubtitle(String articleSubtitle) {
        this.articleSubtitle = articleSubtitle;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }

    public void setArticlePhotoPath(String articlePhotoPath) {
        this.articlePhotoPath = articlePhotoPath;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Long getArticleId() {
        return articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public String getArticleSubtitle() {
        return articleSubtitle;
    }

    public Date getArticleTime() {
        return articleTime;
    }

    public String getArticlePhotoPath() {
        return articlePhotoPath;
    }

    public String getArticleContent() {
        return articleContent;
    }

  
}