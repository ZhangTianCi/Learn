package com.stariches.demo.web;

import com.stariches.demo.domain.User;
import com.stariches.demo.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import javax.servlet.http.*;

@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list/all")
    public List<User> listAll() {
        return userService.selectAll();
    }

    @RequestMapping("/list/test")
    public Map test(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        return request.getParameterMap();
    }
}
