package foo.hk.cn.secutitydemo.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import foo.hk.cn.secutitydemo.sys.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Entity foo.hk.cn.layuidemo.entity.Role
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    @Select("SELECT * FROM t_sys_user_role sur LEFT JOIN t_sys_role sr ON sur.role_id = sr.id WHERE sur.user_id = #{userId}")
    List<Role> findByUserId(Integer userId);

}




