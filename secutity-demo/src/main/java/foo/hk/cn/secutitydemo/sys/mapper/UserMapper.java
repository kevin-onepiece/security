package foo.hk.cn.secutitydemo.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import foo.hk.cn.secutitydemo.sys.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author foo
 * @since 2022-03-10
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
