package top.yuyufeng.vo;

/**
 * Created by yuyufeng on 2017/6/20.
 */
public class MessageVo {
    String href;
    String content;
    String linkName;

    public MessageVo() {
    }

    public MessageVo(String content,String href, String linkName) {
        this.href = href;
        this.content = content;
        this.linkName = linkName;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }
}
