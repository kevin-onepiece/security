package foo.hk.cn.layuidemo.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author foo
 * @since 2022-03-10
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 拦截，如果用户没有登录就跳转登录页面
        Object user = request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("login");
        }
        return true;
    }
}
