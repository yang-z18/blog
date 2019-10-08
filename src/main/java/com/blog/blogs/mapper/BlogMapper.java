package com.blog.blogs.mapper;

import com.blog.blogs.model.Blog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BlogMapper {
    @Insert("insert into blog (bid,uid,btitle,bcontent,bcreatetime) values (#{bid},#{uid},#{btitle},#{bcontent},#{bCreateTime}) ")
    void insertblog(Blog blog);

    @Select("select * from blog")
    List<Blog> findAllBlog();

    @Select("select * from blog where bid=#{bid}")
    Blog getById(String bid);

    @Select("select * from blog where uid=#{uid}")
    List<Blog> findByUid(Long uid);
}
