package com.lpxz.lpxzblog.utils;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Mybatis 工具类
 *
 * @author Liu
 */

public class MybatisUtil {
    private static final ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();
    private static final SqlSessionFactory sqlSessionFactory;

    /* 加载 mybatis-config.xml 配置文件 */
    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 禁止外界通过 new 方法创建
     */
    private MybatisUtil() {
    }

    /**
     * 获取 SqlSession
     */
    public static SqlSession getSqlSession() {
        // 从当前线程中获取 SqlSession 对象
        SqlSession sqlSession = threadLocal.get();
        // 如果 SqlSession 对象为空
        if (sqlSession == null) {
            // 在SqlSessionFactory 非空的情况下，获取 SqlSession 对象
            sqlSession = sqlSessionFactory.openSession();
            // 将 SqlSession 对象与当前线程绑定在⼀起
            threadLocal.set(sqlSession);
        }
        // 返回 SqlSession 对象
        return sqlSession;
    }

    /**
     * 关闭SqlSession与当前线程分开
     */
    public static void closeSqlSession() {
        // 从当前线程中获取 SqlSession 对象
        SqlSession sqlSession = threadLocal.get();
        // 如果 SqlSession 对象非空
        if (sqlSession != null) {
            // 关闭 SqlSession 对象
            sqlSession.close();
            // 分开当前线程与 SqlSession 对象的关系，目的是让 GC 尽早回收
            threadLocal.remove();
        }
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        Connection conn = MybatisUtil.getSqlSession().getConnection();
        System.out.println(conn != null ? "连接成功" : "连接失败");
    }
}