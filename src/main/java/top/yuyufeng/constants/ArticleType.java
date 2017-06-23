package top.yuyufeng.constants;

import org.springframework.util.StringUtils;

/**
 * Created by yuyufeng on 2017/6/23.
 */
public enum ArticleTypeEnum {
    TYPE_JAVA("1", "Java");
    private String key;
    private String value;

    ArticleTypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue(String key) {
        if (StringUtils.isEmpty(key)) {
            return "";
        }
        for (ArticleTypeEnum articleType : ArticleTypeEnum.values()) {
            if (articleType.getKey().equals(key)) {
                return articleType.value;
            }
        }
        return "";
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
