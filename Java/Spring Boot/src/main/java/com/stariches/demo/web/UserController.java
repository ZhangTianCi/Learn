package com.stariches.demo.web;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.servlet.http.*;

import com.stariches.demo.domain.User;
import com.stariches.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/List")
    @ResponseBody
    public List<User> listAll() {
        return userService.selectAll();
    }

    @RequestMapping("/Rqeuest")
    public Map test(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        return request.getParameterMap();
    }

    @RequestMapping("/Get")
    public Map TestPost(String a, int b, boolean c) {
        return new HashMap() {{
            put("a", a);
            put("b", b);
            put("c", c);
        }};
    }

    @RequestMapping("/Page")
    public String Jsp(String a, int b, boolean c, ModelMap model) {
        model.put("UserList",userService.selectAll());
        return "index";
    }

    @PostMapping("/Json")
    public Map TestPost(@RequestBody Map RequestData) {
        return RequestData;
    }
}
