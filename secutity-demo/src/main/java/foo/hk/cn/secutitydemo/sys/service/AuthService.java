package foo.hk.cn.secutitydemo.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import foo.hk.cn.secutitydemo.sys.entity.Auth;

import java.util.List;

/**
 *
 */
public interface AuthService extends IService<Auth> {

    List<Auth> findByUserId(Integer userId);

}
