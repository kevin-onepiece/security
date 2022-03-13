package foo.hk.cn.layuidemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import foo.hk.cn.layuidemo.entity.UserRole;
import foo.hk.cn.layuidemo.service.UserRoleService;
import foo.hk.cn.layuidemo.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}




