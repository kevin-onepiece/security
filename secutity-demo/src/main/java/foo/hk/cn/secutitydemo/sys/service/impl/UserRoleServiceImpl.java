package foo.hk.cn.secutitydemo.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import foo.hk.cn.secutitydemo.sys.entity.UserRole;
import foo.hk.cn.secutitydemo.sys.mapper.UserRoleMapper;
import foo.hk.cn.secutitydemo.sys.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService {

}




