package com.takeaway.mapper.User;

import com.takeaway.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface User_Select_Mapper {

    /**
     * 获得全部用户信息
     * @return
     */
    @Select("select * from account")
    List<User> get_all_user();

    /**
     * 使用用户名和密码，查询用户
     * @param user
     * @return
     */
    @Select("select * from account where username = #{username} and password = #{password}")
    User use_username_password_get_user(User user);

    /**
     * 使用手机号和密码，查询用户
     * @param user
     * @return
     */
    @Select("select * from account where phone = #{phone} and password = #{password}")
    User use_phone_password_get_user(User user);

    /**
     * 使用邮箱和密码，查询用户
     * @param user
     * @return
     */
    @Select("select * from account where email = #{email} and password = #{password}")
    User use_email_password_get_user(User user);

    /**
     * 使用用户名查询用户
     * @param user
     * @return
     */
    @Select("select * from account where username = #{username}")
    User use_username_get_user(User user);

    /**
     * 使用昵称查询用户
     * @param user
     * @return
     */
    @Select("select * from account where username = #{username}")
    User use_cname_get_user(User user);

    /**
     * 使用手机号查询用户
     * @param user
     * @return
     */
    @Select("select * from account where phone = #{phone}")
    User use_phone_get_user(User user);

    /**
     * 使用邮箱查询用户
     * @param user
     * @return
     */
    @Select("select * from account where email = #{email}")
    User use_email_get_user(User user);
}
