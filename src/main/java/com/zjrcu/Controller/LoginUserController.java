package com.zjrcu.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.zjrcu.Mapper.User;
import com.zjrcu.Mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginUserController {

    private final UserMapper userMapper;

    public LoginUserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @PostMapping("/login")
    @ResponseBody
    public ModelAndView loginVerify(HttpServletRequest request, Model model){
        String username = request.getParameter("username");
        String pwd = request.getParameter("password");
        System.out.println(username+pwd);
        User user = new User(username,pwd);
        model.addAttribute("user",user);
        if(userMapper.verifyLoginUser(user.getUsername(),user.getPassword()) == 1){
            return new ModelAndView("upload");
        }
        return new ModelAndView("fail");
    }

    @GetMapping("/")
    public String Error(){
        return "error";
    }
}