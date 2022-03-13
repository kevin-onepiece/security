package foo.hk.cn.secutitydemo.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @author foo
 * @since 2022-03-10
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(Model model, HttpSession session) {
        model.addAttribute("user", session.getAttribute("user"));
        return "index";
    }

    @GetMapping("/view")
    public String view() {
        return "pages/sys/view";
    }

}
