package com.blog.blogs.controller;

import com.blog.blogs.model.BlogDTO;
import com.blog.blogs.service.BlogService;
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
    @GetMapping("/blog/{bid}")
    public String question(@PathVariable(name = "bid") String bid,
                           Model model) {
        BlogDTO blogDTO= blogService.getById(bid);
        model.addAttribute("blogDTO",blogDTO);
        return "blog";
    }

    @GetMapping("/myblog/{uid}")
    public String question(@PathVariable(name = "uid") Long uid,
                           Model model) {
        List<BlogDTO> blogDTO= blogService.getByUid(uid);
        model.addAttribute("blogDTO",blogDTO);
        return "myblog";
    }
}
