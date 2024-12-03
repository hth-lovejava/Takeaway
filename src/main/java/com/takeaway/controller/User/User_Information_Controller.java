package com.takeaway.controller.User;

import com.takeaway.pojo.Result;
import com.takeaway.pojo.User;
import com.takeaway.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/user")
@RestController
public class User_Information_Controller {
    @Autowired
    private UserService userService;

    @GetMapping("/username={username}")
    public Result get_user_information(@PathVariable String username){
        User user = new User();
        user.setUsername(username);
        User user_information = userService.use_username_get_all_information(user);
        if (user_information != null){
            return Result.success(user_information);
        }else {
            return Result.error("未查到个人信息");
        }
    }
}