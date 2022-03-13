package foo.hk.cn.secutitydemo.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import foo.hk.cn.secutitydemo.sys.entity.Role;

import java.util.List;

/**
 *
 */
public interface RoleService extends IService<Role> {

    List<Role> findByUserId(Integer userId);

    Page<Role> listData(Role role, long current, long size);
}
