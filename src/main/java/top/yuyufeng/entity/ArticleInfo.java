package top.yuyufeng.entity;

import java.util.Date;

public class ArticleInfo {
    private Long articleId;

    private String articleTitle;

    private Date articleTime;

    private String articlePhotoPath;

    private String articleContent;

    public ArticleInfo(Long articleId, String articleTitle, Date articleTime, String articlePhotoPath, String articleContent) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleTime = articleTime;
        this.articlePhotoPath = articlePhotoPath;
        this.articleContent = articleContent;
    }

    public Long getArticleId() {
        return articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
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

    @Override
    public String toString() {
        return "ArticleInfo{" +
                "articleId=" + articleId +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleTime=" + articleTime +
                ", articlePhotoPath='" + articlePhotoPath + '\'' +
                ", articleContent='" + articleContent + '\'' +
                '}';
    }
}