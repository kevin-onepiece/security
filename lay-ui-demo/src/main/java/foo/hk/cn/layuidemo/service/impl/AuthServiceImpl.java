package foo.hk.cn.layuidemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import foo.hk.cn.layuidemo.entity.Auth;
import foo.hk.cn.layuidemo.service.AuthService;
import foo.hk.cn.layuidemo.mapper.AuthMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class AuthServiceImpl extends ServiceImpl<AuthMapper, Auth>
    implements AuthService{

}




