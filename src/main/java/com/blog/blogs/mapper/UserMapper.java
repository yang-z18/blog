package com.blog.blogs.mapper;

import com.blog.blogs.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {


    @Insert("insert into user (uid,uname,ubio,uavatar_url,uemail,gmtCreate,gmtModified,token)" +
            "values(#{uid},#{uname},#{ubio},#{uavatar_url},#{uemail},#{gmtCreate},#{gmtModified},#{token})")
    void insertUser(User user);

    @Select("select * from user where uid=#{uid}")
    User selectById(Long uid);

    @Update("update user set gmtModified=#{gmtModified},uavatar_url=#{uavatar_url},uname=#{uname},token=#{token} where uid=#{uid}")
    void updateUser(User dbUser);

    @Select("select * from user where token=#{token}")
    User findByToken(String token);
}
