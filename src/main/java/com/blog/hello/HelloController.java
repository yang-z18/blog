package com.blog.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("name", "你好");
        return "index";
    }
    @PostMapping("/login")
    public String loginn(
            @RequestParam(name="name")String name,
            @RequestParam(name="pwd")String pwd,
            Model model){
        model.addAttribute("name",name);
        model.addAttribute("pwd",pwd);
        return "hello";
    }

}
