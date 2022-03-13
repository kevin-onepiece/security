package foo.hk.cn.secutitydemo.security.handle;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 未登录处理类
 *
 * @author foo
 * @since 2022-03-11
 */
@Component
public class UserNotLoginHandler implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
		response.sendError(403);
	}
}
