package foo.hk.cn.layuidemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import foo.hk.cn.layuidemo.entity.RoleAuth;
import foo.hk.cn.layuidemo.service.RoleAuthService;
import foo.hk.cn.layuidemo.mapper.RoleAuthMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class RoleAuthServiceImpl extends ServiceImpl<RoleAuthMapper, RoleAuth>
    implements RoleAuthService{

}




