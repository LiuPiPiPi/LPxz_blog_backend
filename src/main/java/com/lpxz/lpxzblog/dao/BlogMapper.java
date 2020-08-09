package com.lpxz.lpxzblog.dao;

import com.lpxz.lpxzblog.entity.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    /**
     * 插入博客
     * @param blog
     */
    void addBlog(Blog blog);

    /**
     * 查询博客
     */
    List<Blog> queryBlogIf(Map map);

    List<Blog> queryBlogChoose(Map map);

    /**
     * 更新博客
     */
    void updateBlog(Map map);

    List<Blog> queryBlogForeach(Map map);
}
