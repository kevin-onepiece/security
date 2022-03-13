package foo.hk.cn.secutitydemo.security;

import cn.hutool.core.util.StrUtil;
import foo.hk.cn.secutitydemo.security.entity.UserDetails;
import foo.hk.cn.secutitydemo.security.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author foo
 * @since 2022-03-11
 */
@Component
@RequiredArgsConstructor
public class UserAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        if (StrUtil.isEmpty(userName)) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        if ((userDetails == null) || !new BCryptPasswordEncoder().matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("用户名或密码错误");
        }

        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
