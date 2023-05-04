package com.smartCloth.controller;

import com.alibaba.fastjson.JSONObject;
import com.smartCloth.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    JSONObject login(@RequestBody JSONObject param){
        return userService.login(param);
    }

    // 查看用户信息
    @PostMapping("/info")
    JSONObject getUser(@RequestBody JSONObject param){
        return userService.getUser(param);
    }

    @PostMapping("/insert")
    JSONObject insertUser(@RequestBody JSONObject param){return userService.insertUser(param);}

    @PostMapping("/edit")
    JSONObject editUser(@RequestBody JSONObject param){
        return userService.editUser(param);
    }

    @PostMapping("/delete")
    JSONObject deleteUser(@RequestBody JSONObject param){
        return userService.deleteUser(param);
    }



}
