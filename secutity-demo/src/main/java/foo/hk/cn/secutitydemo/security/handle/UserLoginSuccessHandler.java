package foo.hk.cn.secutitydemo.security.handle;

import foo.hk.cn.secutitydemo.common.vo.Response;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功处理类
 *
 * @author foo
 * @since 2022-03-11
 */
@Component
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
		Response.responseJson(response, Response.success("登录成功"));
	}
}
