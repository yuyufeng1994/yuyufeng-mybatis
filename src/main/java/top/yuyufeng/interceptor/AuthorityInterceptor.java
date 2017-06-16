package top.yuyufeng.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by yuyufeng on 2017/1/13.
 */
public class AuthorityInterceptor implements HandlerInterceptor {
    @Resource(name = "urlMap")
    private Map<String, String> urlMap;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURL().toString();
        HttpSession session = request.getSession();
        String res = (String) session.getAttribute("ISUSERLOGIN");
        if (res != null && "true".equals(res)) {
            return true;
        }
        response.sendRedirect(urlMap.get("appServer") + "/login?returnUrl=" + url);
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
