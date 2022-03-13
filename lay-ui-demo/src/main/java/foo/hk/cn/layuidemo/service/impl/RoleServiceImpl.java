package foo.hk.cn.layuidemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import foo.hk.cn.layuidemo.entity.Role;
import foo.hk.cn.layuidemo.service.RoleService;
import foo.hk.cn.layuidemo.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




