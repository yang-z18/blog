package com.blog.blogs.service;

import com.blog.blogs.dto.PaginationDTO;
import com.blog.blogs.mapper.BlogMapper;
import com.blog.blogs.mapper.UserMapper;
import com.blog.blogs.model.Blog;
import com.blog.blogs.model.BlogDTO;
import com.blog.blogs.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService {
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private UserMapper userMapper;
    public void insertblog(Blog blog) {
        blogMapper.insertblog(blog);
    }

    public PaginationDTO findAll(Integer page, Integer size){
        //size*(page-1)
        Integer offset = size*(page-1);
        List<Blog> blogs = blogMapper.findAllBlog(offset,size);
        List<BlogDTO> blogDTOList = new ArrayList<>();
        PaginationDTO paginationDTO = new PaginationDTO();

        for (Blog blog : blogs){
            User user = userMapper.selectById(blog.getUid());
            BlogDTO blogDTO = new BlogDTO();
            blogDTO.setUser(user);
            BeanUtils.copyProperties(blog,blogDTO);
            blogDTOList.add(blogDTO);
        }
        paginationDTO.setBlogDTOS(blogDTOList);
        Integer totalCount = blogMapper.count();
        paginationDTO.setPagination(totalCount,page,size);
        return paginationDTO;
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

    public List<BlogDTO> search(String search) {
       List<Blog> blogList= blogMapper.search(search);
        List<BlogDTO> blogDTOList = new ArrayList<>();
        for (Blog blog:blogList){
            BlogDTO blogDTO = new BlogDTO();
            User user = userMapper.selectById(blog.getUid());
            blogDTO.setUser(user);
            BeanUtils.copyProperties(blog,blogDTO);
            blogDTOList.add(blogDTO);
        }

        return blogDTOList;
    }
}
