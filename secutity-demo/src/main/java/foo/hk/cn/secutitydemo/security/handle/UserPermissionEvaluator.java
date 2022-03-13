package foo.hk.cn.secutitydemo.security.handle;

import foo.hk.cn.secutitydemo.security.entity.UserDetails;
import foo.hk.cn.secutitydemo.sys.entity.Auth;
import foo.hk.cn.secutitydemo.sys.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用户权限注解处理类
 *
 * @author foo
 * @since 2022-03-11
 */
@Component
@RequiredArgsConstructor
public class UserPermissionEvaluator implements PermissionEvaluator {

    private final AuthService authService;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		// 用户权限
		Set<String> permissions = new HashSet<String>();

		// 查询用户权限
		List<Auth> authList = authService.findByUserId(userDetails.getId());
		authList.forEach(auth -> {
			permissions.add(auth.getPermission());
		});

		// 判断是否拥有权限
		if (permissions.stream().filter(p -> (permission.toString().startsWith(p))).count() > 0) {
			return true;
		}
		return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
