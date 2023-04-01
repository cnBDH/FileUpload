package com.yx.controller;


import com.yx.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author YinXiong
 */
@Controller
public class UserController {

    private final UserMapper usermapper;

    public UserController(UserMapper userMapper) {
        this.usermapper = userMapper;
    }

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
    public void deleteUser(@PathVariable("id")Integer id) {
        usermapper.deleteById(id);
    }

}