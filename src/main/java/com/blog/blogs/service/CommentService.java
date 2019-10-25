package com.blog.blogs.service;

import com.blog.blogs.mapper.CommentMapper;
import com.blog.blogs.mapper.UserMapper;
import com.blog.blogs.model.Comment;
import com.blog.blogs.model.CommentDTO;
import com.blog.blogs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserMapper userMapper;
    public void insert(Comment comment) {
        commentMapper.insert(comment);
    }

    public List<CommentDTO> findById(Long bid) {
        List<Comment> comments = commentMapper.findById(bid);
        List<CommentDTO> commentDTOS = new ArrayList<>();
        for (Comment comment:comments){
            CommentDTO commentDTO = new CommentDTO();
            User user=userMapper.selectById(comment.getUid());
            commentDTO.setUser(user);
            commentDTOS.add(commentDTO);
        }
        return commentDTOS;
    }
}
