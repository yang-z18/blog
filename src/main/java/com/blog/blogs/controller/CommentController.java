package com.blog.blogs.controller;

import com.blog.blogs.model.Comment;
import com.blog.blogs.model.User;
import com.blog.blogs.service.CommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody Comment comment,
                       HttpServletRequest request){
        User user =(User)request.getSession().getAttribute("user");
        Long uid = user.getUid();
        comment.setCreatetime(System.currentTimeMillis());
        comment.setUid(uid);
        commentService.insert(comment);
        return null;
    }

}
