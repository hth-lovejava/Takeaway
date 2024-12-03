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
    @Insert("insert into account(username,username,cname,phone,adress,email)" +
            "values(#{username},#{username},#{cname},#{phone},#{adress},#{email})")
    void add_user(User user);
}
