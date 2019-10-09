package com.blog.blogs.controller;

import com.blog.blogs.dto.PaginationDTO;
import com.blog.blogs.model.Blog;
import com.blog.blogs.model.BlogDTO;
import com.blog.blogs.service.BlogService;
import com.sun.org.apache.xpath.internal.operations.Mod;
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
                        Model model,
                        @RequestParam(name="page",defaultValue = "1") Integer page,
                        @RequestParam(name="size",defaultValue = "5") Integer size){
        PaginationDTO pagination = blogService.findAll(page,size);
        model.addAttribute("pagination",pagination);
        return "index";
    }

    @GetMapping("/search")
    public String search(Model model,
                         @RequestParam(name="search",required = false) String search){
        List<BlogDTO> blogDTOS= blogService.search(search);
        model.addAttribute("blogDTOS",blogDTOS);
        return "search";
    }

}
