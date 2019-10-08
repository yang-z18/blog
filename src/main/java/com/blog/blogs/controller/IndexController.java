package com.blog.blogs.controller;

import com.blog.blogs.model.Blog;
import com.blog.blogs.model.BlogDTO;
import com.blog.blogs.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private BlogService blogService;
    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model){
        List<BlogDTO> blogDTOS = blogService.findAll();
        model.addAttribute("blogDTOS",blogDTOS);
        return "index";
    }
}
