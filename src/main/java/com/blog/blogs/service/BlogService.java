package com.blog.blogs.service;

import com.blog.blogs.mapper.BlogMapper;
import com.blog.blogs.mapper.UserMapper;
import com.blog.blogs.model.Blog;
import com.blog.blogs.model.BlogDTO;
import com.blog.blogs.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private UserMapper userMapper;
    public void insertblog(Blog blog) {
        blogMapper.insertblog(blog);
    }

    public List<BlogDTO> findAll(){
        List<Blog> blogs = blogMapper.findAllBlog();
        List<BlogDTO> blogDTOList = new ArrayList<>();
        for (Blog blog : blogs){
            User user = userMapper.selectById(blog.getUid());
            BlogDTO blogDTO = new BlogDTO();
            blogDTO.setUser(user);
            BeanUtils.copyProperties(blog,blogDTO);
            blogDTOList.add(blogDTO);
        }
        return blogDTOList;
    }

    public BlogDTO getById(String bid) {
        Blog blog = blogMapper.getById(bid);
        User user = userMapper.selectById(blog.getUid());
        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setUser(user);
        BeanUtils.copyProperties(blog,blogDTO);
        return blogDTO;
    }

    public List<BlogDTO> getByUid(Long uid) {
        List<Blog> blogList = blogMapper.findByUid(uid);
        User user = userMapper.selectById(uid);
        List<BlogDTO> blogDTOList = new ArrayList<>();
        for (Blog blog : blogList){
            BlogDTO blogDTO = new BlogDTO();
            blogDTO.setUser(user);
            BeanUtils.copyProperties(blog,blogDTO);
            blogDTOList.add(blogDTO);
        }
        return blogDTOList;
    }
}
