package foo.hk.cn.secutitydemo.security.handle;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登出成功处理类
 *
 * @author foo
 * @since 2022-03-11
 */
@Component
public class UserLogoutSuccessHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		SecurityContextHolder.clearContext();
		response.sendRedirect("login");
	}
}
