package com.takeaway.service.impl;

import com.takeaway.mapper.User.User_Select_Mapper;
import com.takeaway.pojo.User;
import com.takeaway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService_Impl implements UserService {
    @Autowired
    private User_Select_Mapper user_select_mapper;

    /**
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return user_select_mapper.login(user);
    }
}
