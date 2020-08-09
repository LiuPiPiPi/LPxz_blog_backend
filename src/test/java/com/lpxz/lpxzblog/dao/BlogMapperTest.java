package com.lpxz.lpxzblog.dao;


import com.lpxz.lpxzblog.entity.Blog;
import com.lpxz.lpxzblog.utils.IDUtil;
import com.lpxz.lpxzblog.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BlogMapperTest {
    @Test
    public void testAddBlog() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();

        blog.setId(IDUtil.getId());
        blog.setTitle("计算机网络");
        blog.setAuthor("Liu");
        blog.setViews(999);
        mapper.addBlog(blog);

        blog.setId(IDUtil.getId());
        blog.setTitle("计算机网络33333");
        blog.setAuthor("Liu");
        blog.setViews(999);
        mapper.addBlog(blog);

        blog.setId(IDUtil.getId());
        blog.setTitle("计算");
        blog.setAuthor("Liu");
        blog.setViews(999);
        mapper.addBlog(blog);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testQueryBlogIf() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title", "计算机网络");
        map.put("author", "Liu");

        List<Blog> blogs = mapper.queryBlogIf(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testQueryBlogChoose() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title", "计算机网络");

        List<Blog> blogs = mapper.queryBlogChoose(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateBlog() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title", "计算机网络很简单");
        map.put("author", "wang");
        map.put("id", "864ce224469c4d1ab41067b335ac6494");

        mapper.updateBlog(map);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testQueryBlogForeach() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        List<String> ids = new ArrayList<>();
        ids.add("1");
        ids.add("2");
        ids.add("3");
        map.put("ids", ids);

        List<Blog> blogs = mapper.queryBlogForeach(map);

        System.out.println(blogs);

        sqlSession.commit();
        sqlSession.close();
    }
}
