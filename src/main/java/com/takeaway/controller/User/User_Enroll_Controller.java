package com.takeaway.controller.User;

import com.takeaway.pojo.Result;
import com.takeaway.pojo.User;
import com.takeaway.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/enroll")
@RestController
public class User_Enroll_Controller {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public Result user_enroll(@RequestBody User user){
        log.info("开始注册,{}", user);
        userService.add_user(user);
        return Result.success("注册成功");
    }
}