package foo.hk.cn.layuidemo.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import foo.hk.cn.layuidemo.common.Response;
import foo.hk.cn.layuidemo.entity.User;
import foo.hk.cn.layuidemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author foo
 * @since 2022-03-10
 */
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Response<User> login(User user, HttpSession session) {
        if (StrUtil.hasEmpty(user.getUsername(), user.getPassword())) {
            return Response.error("用户名或者密码不能为空");
        }
        User queryedUser = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUsername, user.getUsername()));
        if (queryedUser == null || !BCrypt.checkpw(user.getPassword(), queryedUser.getPassword())) {
            return Response.error("用户名或密码错误");
        }
        session.setAttribute("user", queryedUser);
        return Response.success("登录成功", queryedUser);
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

}
