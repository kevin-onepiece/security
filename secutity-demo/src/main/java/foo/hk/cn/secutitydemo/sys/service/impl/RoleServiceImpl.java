package foo.hk.cn.secutitydemo.sys.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import foo.hk.cn.secutitydemo.sys.entity.Role;
import foo.hk.cn.secutitydemo.sys.mapper.RoleMapper;
import foo.hk.cn.secutitydemo.sys.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
        implements RoleService {

    private final RoleMapper roleMapper;

    @Override
    public List<Role> findByUserId(Integer userId) {
        return roleMapper.findByUserId(userId);
    }

    @Override
    public Page<Role> listData(Role role, long current, long size) {
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(role.getId() != null, Role::getId, role.getId())
                .eq(StrUtil.isNotBlank(role.getRoleCode()), Role::getRoleCode, role.getRoleCode())
                .eq(StrUtil.isNotBlank(role.getRoleName()), Role::getRoleName, role.getRoleName());
        return roleMapper.selectPage(new Page<>(current, size), queryWrapper);
    }
}




