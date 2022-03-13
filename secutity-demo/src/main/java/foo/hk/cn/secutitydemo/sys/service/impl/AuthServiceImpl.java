package foo.hk.cn.secutitydemo.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import foo.hk.cn.secutitydemo.sys.entity.Auth;
import foo.hk.cn.secutitydemo.sys.mapper.AuthMapper;
import foo.hk.cn.secutitydemo.sys.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl extends ServiceImpl<AuthMapper, Auth>
    implements AuthService {

    private final AuthMapper authMapper;

    @Override
    public List<Auth> findByUserId(Integer userId) {
        return authMapper.findByUserId(userId);
    }
}




