package com.blog.blogs.controller;

import com.blog.blogs.model.BlogDTO;
import com.blog.blogs.model.Comment;
import com.blog.blogs.model.CommentDTO;
import com.blog.blogs.service.BlogService;
import com.blog.blogs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CommentService commentService;
    @GetMapping("/blog/{bid}")
    public String blog(@PathVariable(name = "bid") Long bid,
                           Model model) {
        BlogDTO blogDTO= blogService.getById(bid);
        List<CommentDTO> comments=commentService.findById(bid);
        model.addAttribute("comments",comments);
        model.addAttribute("blogDTO",blogDTO);
        return "blog";
    }

    @GetMapping("/myblog/{uid}")
    public String myblog(@PathVariable(name = "uid") Long uid,
                           Model model) {
        List<BlogDTO> blogDTO= blogService.getByUid(uid);
        model.addAttribute("blogDTO",blogDTO);
        return "myblog";
    }
}
