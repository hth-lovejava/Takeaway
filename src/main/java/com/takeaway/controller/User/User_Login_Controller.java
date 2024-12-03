package com.takeaway.controller.User;

import com.takeaway.pojo.Result;
import com.takeaway.pojo.User;
import com.takeaway.service.UserService;
import com.takeaway.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequestMapping("/login")
@RestController
public class User_Login_Controller {
    @Autowired
    private UserService userService;

    /**
     * 使用用户名登录
     * @param user
     * @return
     */
    @PostMapping("/username")
    public Result use_username_login(@RequestBody User user){
        log.info("用户登录：{}",user);
        User u = userService.use_username_login(user);
        //登录成功，发放令牌
        if (u != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("Username", u.getUsername());
            claims.put("Password", u.getPassword());
            String jwt = JwtUtils.get_jwt(claims);
            return Result.success(jwt);
        } else {
            //登录失败，返回错误信息
            return Result.error("用户名或密码错误");
        }
    }

    /**
     * 使用手机号登录
     * @param user
     * @return
     */
    @PostMapping("/phone")
    public Result use_phone_login(@RequestBody User user){
        log.info("用户登录：{}",user);
        User u = userService.use_phone_login(user);
        //登录成功，发放令牌
        if (u != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("Phone", u.getPhone());
            claims.put("Password", u.getPassword());
            String jwt = JwtUtils.get_jwt(claims);
            return Result.success(jwt);
        } else {
            //登录失败，返回错误信息
            return Result.error("用户名或密码错误");
        }
    }

    /**
     * 使用邮箱登录
     * @param user
     * @return
     */
    @PostMapping("/email")
    public Result use_email_login(@RequestBody User user){
        log.info("用户登录：{}",user);
        User u = userService.use_email_login(user);
        //登录成功，发放令牌
        if (u != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("Email", u.getEmail());
            claims.put("Password", u.getPassword());
            String jwt = JwtUtils.get_jwt(claims);
            return Result.success(jwt);
        } else {
            //登录失败，返回错误信息
            return Result.error("用户名或密码错误");
        }
    }
}