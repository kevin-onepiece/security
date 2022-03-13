package foo.hk.cn.secutitydemo.sys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import foo.hk.cn.secutitydemo.common.vo.Response;
import foo.hk.cn.secutitydemo.sys.entity.Role;
import foo.hk.cn.secutitydemo.sys.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author foo
 * @since 2022-03-11
 */
@Controller
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/list")
    private String list() {
        return "pages/sys/roleList";
    }

    @GetMapping("/listData")
    @ResponseBody
    private Response<Page<Role>> listData(Role role, @RequestParam(name = "page") long current,
                                          @RequestParam(name = "limit") long size) {
        Page<Role> roles = roleService.listData(role, current, size);
        return Response.success(roles);
    }

}
