package foo.hk.cn.secutitydemo.security.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import foo.hk.cn.secutitydemo.security.entity.UserDetails;
import foo.hk.cn.secutitydemo.sys.entity.Role;
import foo.hk.cn.secutitydemo.sys.entity.User;
import foo.hk.cn.secutitydemo.sys.service.RoleService;
import foo.hk.cn.secutitydemo.sys.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * @author foo
 * @since 2022-03-11
 */
@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	private final RoleService roleService;
	private final UserService userService;

	/**
	 * 根据用户名查用户信息
	 *
	 * @param username 用户名称
	 * @return 用户详细信息
	 */
	@Override
	public UserDetails loadUserByUsername(String username) {
		LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
		User queriedUser = userService.getOne(wrapper.eq(User::getUsername, username));
		if (queriedUser != null) {
			UserDetails userDetails = new UserDetails();
			BeanUtils.copyProperties(queriedUser, userDetails);

			List<Role> roles = roleService.findByUserId(queriedUser.getId());
			HashSet<GrantedAuthority> grantedAuthorities = new HashSet<>();
			roles.forEach(role -> {
				SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" + role.getRoleCode());
				grantedAuthorities.add(simpleGrantedAuthority);
			});
			userDetails.setAuthorities(grantedAuthorities);
			return userDetails;
		}
		return null;
	}

}
