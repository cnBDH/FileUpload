package com.zjrcu.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjrcu.Mapper.User;
import com.zjrcu.Mapper.UserMapper;

@Controller
public class IndexController {


    @Autowired
    UserMapper usermapper ;

    @ResponseBody
    @GetMapping("/user")
    public List<User> listUser(){
        return usermapper.list();
    }

    @ResponseBody
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id")Integer id) {

        User user = usermapper.getById(id);
        return user;
    }

    @ResponseBody
    @GetMapping("/user/insert")
    public User insertUser(User user) {
        usermapper.insert(user);
        return user;
    }

    @ResponseBody
    @GetMapping("/user/update-password")
    public User updateUserPassword(User user) {
        usermapper.updatePassword(user);
        return user;
    }

    @ResponseBody
    @GetMapping("/user/delete/{id}")
    public int deleteUser(@PathVariable("id")Integer id) {
        return usermapper.deleteById(id);
    }

}