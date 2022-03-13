package foo.hk.cn.secutitydemo.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import foo.hk.cn.secutitydemo.sys.entity.Auth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Entity foo.hk.cn.layuidemo.entity.Auth
 */
@Mapper
public interface AuthMapper extends BaseMapper<Auth> {

	@Select("SELECT a.* FROM t_sys_auth a LEFT JOIN t_sys_role_auth ra ON ra.auth_id = a.id LEFT JOIN t_sys_user_role ur ON ur.role_id = ra.role_id WHERE ur.user_id = #{userId}")
    List<Auth> findByUserId(Integer userId);

}




