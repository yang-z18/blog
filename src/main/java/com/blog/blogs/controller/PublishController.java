package com.blog.blogs.controller;

import com.blog.blogs.mapper.UserMapper;
import com.blog.blogs.model.Blog;
import com.blog.blogs.model.User;
import com.blog.blogs.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class PublishController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BlogService blogService;
    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "uid",required = false)Long uid,
            @RequestParam(value = "bcontent",required = false)String bcontent,
            @RequestParam(value = "btitle",required = false)String btitle
    ){
        Blog blog= new Blog();
        blog.setBcontent(bcontent);
        blog.setbCreateTime(System.currentTimeMillis());
        blog.setUid(uid);
        blog.setBtitle(btitle);
        blog.setBid(UUID.randomUUID().toString());
        blogService.insertblog(blog);
        return "redirect:/";
    }
}
