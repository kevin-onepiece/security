package foo.hk.cn.secutitydemo.security.handle;

import foo.hk.cn.secutitydemo.common.vo.Response;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败处理类
 *
 * @author foo
 * @since 2022-03-11
 */
@Component
public class UserLoginFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException {
		Response.responseJson(response, Response.error(500, "登录失败", exception.getMessage()));
	}
}
