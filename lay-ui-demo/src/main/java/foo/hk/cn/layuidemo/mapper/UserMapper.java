package foo.hk.cn.layuidemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import foo.hk.cn.layuidemo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author foo
 * @since 2022-03-10
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
