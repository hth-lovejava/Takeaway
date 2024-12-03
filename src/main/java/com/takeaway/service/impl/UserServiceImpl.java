package com.takeaway.service.impl;

import com.takeaway.mapper.User.User_Insert_Mapper;
import com.takeaway.mapper.User.User_Select_Mapper;
import com.takeaway.pojo.User;
import com.takeaway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private User_Select_Mapper user_select_mapper;
    @Autowired
    private User_Insert_Mapper user_insert_mapper;

    /**
     * 查询全部用户信息
     * @return
     */
    @Override
    public List<User> get_all_user() {
        return user_select_mapper.get_all_user();
    }

    /**
     * 使用用户名获得个人信息
     * @return
     */
    @Override
    public User use_username_get_all_information(User user) {
        return user_select_mapper.use_username_get_user(user);
    }

    /**
     * 使用用户名登录
     * @param user
     * @return
     */
    @Override
    public User use_username_login(User user) {
        return user_select_mapper.use_username_password_get_user(user);
    }

    /**
     * 使用手机号登录
     * @param user
     * @return
     */
    @Override
    public User use_phone_login(User user) {
        return user_select_mapper.use_phone_password_get_user(user);
    }

    /**
     * 使用邮箱登录
     * @param user
     * @return
     */
    @Override
    public User use_email_login(User user) {
        return user_select_mapper.use_email_password_get_user(user);
    }

    /**
     * 用户名查重
     * @param user
     * @return
     */
    @Override
    public User get_username_repeat(User user) {
        return user_select_mapper.use_username_get_user(user);
    }

    /**
     * 邮箱查重
     * @param user
     * @return
     */
    @Override
    public User get_email_repeat(User user) {
        return user_select_mapper.use_email_get_user(user);
    }

    /**
     * 手机号查重
     * @param user
     * @return
     */
    @Override
    public User get_phone_repeat(User user) {
        return user_select_mapper.use_phone_get_user(user);
    }

    /**
     * 注册用户
     * @param user
     */
    @Override
    public void add_user(User user) {
        user_insert_mapper.add_user(user);
    }
}