package com.blog.blogs.service;

import com.blog.blogs.mapper.BlogMapper;
import com.blog.blogs.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
    @Autowired
    private BlogMapper blogMapper;
    public void insertblog(Blog blog) {
        blogMapper.insertblog(blog);
    }
}
