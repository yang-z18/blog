package com.blog.blogs.mapper;

import com.blog.blogs.model.Blog;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BlogMapper {
    @Insert("insert into blog (bid,uid,btitle,bcontent,bcreatetime,modifiedtime) " +
            "values (#{bid},#{uid},#{btitle},#{bcontent},#{bCreateTime},#{modifiedTime}) ")
    void insertblog(Blog blog);

    @Select("select * from blog limit #{offset},#{size}")
    List<Blog> findAllBlog(@Param(value = "offset") Integer offset,@Param(value = "size") Integer size);

    @Select("select * from blog where bid=#{bid}")
    Blog getById(Long bid);

    @Select("select * from blog where uid=#{uid}")
    List<Blog> findByUid(Long uid);

    @Select("select count(1) from blog")
    Integer count();

    @Select("select * from blog where btitle REGEXP #{search}")
    List<Blog> search(@Param(value = "search")String search);

    @Update("update blog set modifiedtime = #{modifiedTime},btitle = #{btitle}," +
            "bcontent = #{bcontent} where bid= #{bid}")
    void update(Blog updateBlog);
}
