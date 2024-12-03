package com.takeaway.controller.User;

import com.takeaway.pojo.Result;
import com.takeaway.pojo.User;
import com.takeaway.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/repeat")
@RestController
public class User_Repeat_Controller {
    @Autowired
    private UserService userService;

    @GetMapping("/username={username}")
    public Result username_repeat(@PathVariable String username){
        User user = new User();
        user.setUsername(username);
        User user_repeat = userService.get_username_repeat(user);
        if (user_repeat == null){
            return Result.success("用户名有效");
        }else {
            return Result.error("用户名已存在");
        }
    }

    @GetMapping("/phone={phone}")
    public Result phone_repeat(@PathVariable String phone){
        User user = new User();
        user.setPhone(phone);
        User user_repeat = userService.get_phone_repeat(user);
        if (user_repeat == null){
            return Result.success("手机号有效");
        }else {
            return Result.error("手机号已存在");
        }
    }

    @GetMapping("/email={email}")
    public Result email_repeat(@PathVariable String email){
        User user = new User();
        user.setEmail(email);
        User user_repeat = userService.get_email_repeat(user);
        if (user_repeat == null){
            return Result.success("邮箱有效");
        }else {
            return Result.error("邮箱已存在");
        }
    }
}
