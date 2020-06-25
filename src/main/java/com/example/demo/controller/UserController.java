package com.example.demo.controller;


import com.example.demo.proj.User;
import com.example.demo.proj.UserInfo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author YeZhiyue
 * @since 2020-06-25
 */
//@RestController
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("user.html")
    public String item(ModelMap map) {
        map.addAttribute("uList", userService.getAllUser());
        return "index";
    }

    @RequestMapping("selectUser")
    public String selectUser(UserInfo userInfo, ModelMap map) {
        map.addAttribute("uList", userService.selectUser(userInfo));
        return "index";
    }

    @RequestMapping("deleteUser")
    public String deleteUser(UserInfo userInfo, ModelMap map) {
        userService.deleteUser(userInfo);
        map.addAttribute("uList", userService.getAllUser());
        return "index";
    }


    @RequestMapping("insertUser")
    public String insertUser(User user,ModelMap map) {
        int result = userService.insertUser(user);
        map.addAttribute("uList", userService.getAllUser());
        return "index";
    }

    @RequestMapping("updateUser")
    public String updateUser(User user,ModelMap map) {
        userService.updateById(user);
        List<User> userList = userService.getAllUser();
        map.addAttribute("uList", userList);
        return "index";
    }

    @RequestMapping("selectByPage")
    public String selectByPage(int currentPage,ModelMap map) {
        userService.selectByPage(currentPage);
        return "index";
    }
}

