package foo.hk.cn.layuidemo.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import foo.hk.cn.layuidemo.entity.User;
import foo.hk.cn.layuidemo.mapper.UserMapper;
import foo.hk.cn.layuidemo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author foo
 * @since 2022-03-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * 查询列表数据
     *
     * @param user    系统用户
     * @param current 当前页
     * @param size    每页显示条数
     * @return
     */
    @Override
    public Page<User> listData(User user, long current, long size) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (null != user.getId()) {
            queryWrapper.eq("id", user.getId());
        }
        if (StrUtil.isNotBlank(user.getUsername())) {
            queryWrapper.like("username", user.getUsername());
        }
        if (StrUtil.isNotBlank(user.getNickname())) {
            queryWrapper.like("nickname", user.getNickname());
        }
        return baseMapper.selectPage(new Page<>(current, size), queryWrapper);
    }

    /**
     * 检验用户名称是否唯一
     *
     * @param userName 用户名称
     * @return
     */
    @Override
    public Boolean checkUserName(String userName) {
        if (StrUtil.isNotBlank(userName)) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("username", userName);
            Integer count = baseMapper.selectCount(queryWrapper);
            return (count != null && count > 0) ? false : true;
        }
        return false;
    }


}
