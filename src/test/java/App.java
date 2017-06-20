import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.HtmlUtils;

/**
 * Created by yuyufeng on 2017/6/2.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:spring/"})
public class App {
    public static void main(String[] args) {
        String str="";
        String res = HtmlUtils.htmlEscape(str);
        System.out.println(res);
    }
}
