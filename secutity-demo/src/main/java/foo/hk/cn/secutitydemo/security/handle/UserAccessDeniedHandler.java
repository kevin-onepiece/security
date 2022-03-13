package foo.hk.cn.secutitydemo.security.handle;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 无权限处理类
 *
 * @author foo
 * @since 2022-03-11
 */
@Component
public class UserAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException {
		response.sendError(403);
	}

}
