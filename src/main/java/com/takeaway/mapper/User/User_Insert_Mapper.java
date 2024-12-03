package com.takeaway.mapper.User;

import com.takeaway.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface User_Insert_Mapper {
    /**
     * 添加用户
     * @param user
     */
    @Insert("insert into account(username,password,cname,phone,address,email)" +
            "values(#{username},#{password},#{cname},#{phone},#{address},#{email})")
    void add_user(User user);
}
