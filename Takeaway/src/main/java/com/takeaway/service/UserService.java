package com.takeaway.service;

import com.takeaway.pojo.User;

import java.util.List;

public interface UserService {
    /**
     * 查询全部用户信息
     * @return
     */
    List<User> get_all_user();

    /**
     * 使用用户名获得个人信息
     * @return
     */
    User use_username_get_all_information(User user);

    /**
     * 使用用户名登录
     * @param user
     * @return
     */
    User use_username_login(User user);

    /**
     * 使用手机号登录
     * @param user
     * @return
     */
    User use_phone_login(User user);

    /**
     * 使用邮箱登录
     * @param user
     * @return
     */
    User use_email_login(User user);

    /**
     * 用户名查重
     * @param user
     * @return
     */
    User get_username_repeat(User user);

    /**
     * 手机号查重
     * @param user
     * @return
     */
    User get_phone_repeat(User user);

    /**
     * 邮箱查重
     * @param user
     * @return
     */
    User get_email_repeat(User user);

    /**
     * 注册用户
     * @param user
     */
    void add_user(User user);
}
