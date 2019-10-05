package com.blog.blogs.service;

import com.blog.blogs.mapper.UserMapper;
import com.blog.blogs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public void createOrUpdate(User user){
        User dbUser = userMapper.selectById(user.getUid());
        if (dbUser == null) {
            // 插入
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insertUser(user);
        } else {
            //更新
            dbUser.setGmtModified(System.currentTimeMillis());
            dbUser.setUavatar_url(user.getUavatar_url());
            dbUser.setUname(user.getUname());
            dbUser.setToken(user.getToken());
            userMapper.updateUser(dbUser);
        }

    }
}
