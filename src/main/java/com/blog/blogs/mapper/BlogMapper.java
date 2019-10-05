package com.blog.blogs.mapper;

import com.blog.blogs.model.Blog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogMapper {
    @Insert("insert into blog (bid,uid,btitle,bcontent,bcreatetime) values (#{bid},#{uid},#{btitle},#{bcontent},#{bCreateTime}) ")
    void insertblog(Blog blog);
}
