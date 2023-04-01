package com.yx.controller;

import com.yx.mapper.UserMapper;
import com.yx.utils.Md5Utils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * 作者：yx
 * 时间：2022/10/9
 *
 **/
public class LoginController {

    private UserMapper userMapper;

    @GetMapping("/login")
    public String loginIndex() {
        return "login/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam(name = "username")String username, @RequestParam(name = "password")String password,
                        Model model, HttpServletRequest request) {
        if(userMapper.verifyLoginUser(username,password)>0) {
            User user = new User(username, password);
            String pwd = user.getPassword();
            String password1 = Md5Utils.md5(password).toUpperCase();
            String password2 = Md5Utils.md5(password1).toUpperCase();
            if (pwd.equals(password2)) {
                model.addAttribute("user", user);
                request.getSession().setAttribute("user", user);
                return "redirect:/upload/upload";
            }
        }
        return "login/fail";
    }

    @GetMapping("/register")
    public String register() {
        return "login/register";
    }

    @PostMapping("/register")
    public String register(String username,String password){

        return "/login/login";
    }

    @GetMapping({"", "/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/error")
    public String error() {
        return "/login/error";
    }


}
