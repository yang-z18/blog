package com.blog.blogs.controller;

import com.blog.blogs.mapper.UserMapper;
import com.blog.blogs.model.Blog;
import com.blog.blogs.model.BlogDTO;
import com.blog.blogs.model.User;
import com.blog.blogs.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
            @RequestParam(value = "bid",required = false)Long bid,
            @RequestParam(value = "uid",required = false)Long uid,
            @RequestParam(value = "bcontent",required = false)String bcontent,
            @RequestParam(value = "btitle",required = false)String btitle
    ){
        Blog blog= new Blog();
        blog.setUid(uid);
        blog.setBid(bid);
        blog.setBcontent(bcontent);
        blog.setBtitle(btitle);
        blogService.createOrUpdate(blog);
        return "redirect:/";
    }
    @GetMapping("/publish/{bid}")
    private String edit(@PathVariable(name = "bid")Long bid,
                        Model model){
        BlogDTO blogDTO= blogService.getById(bid);
        model.addAttribute("bid",bid);
        model.addAttribute("btitle",blogDTO.getBtitle());
        model.addAttribute("bcontent",blogDTO.getBcontent());
        model.addAttribute("uid",blogDTO.getUid());
        return "publish";
    }
}
