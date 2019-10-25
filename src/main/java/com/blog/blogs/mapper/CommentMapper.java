package com.blog.blogs.mapper;

import com.blog.blogs.model.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Insert("insert into comment (uid,bid,ccontent,createtime) values(#{uid},#{bid},#{ccontent},#{createtime})")
    void insert(Comment comment);

    @Select("select * from comment where bid=#{bid}")
    List<Comment> findById(Long bid);
}
