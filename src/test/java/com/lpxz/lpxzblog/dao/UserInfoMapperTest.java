package com.lpxz.lpxzblog.dao;

import com.lpxz.lpxzblog.entity.UserInfo;
import com.lpxz.lpxzblog.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.*;

public class UserInfoMapperTest {
    static Logger logger = Logger.getLogger(UserInfoMapperTest.class);

    @Test
    public void getUserInfoByIdTest() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);

        UserInfo userInfo = mapper.getUserInfoById(1); // 参数为 id
        System.out.println(userInfo);

        // 提交并关闭 SqlSession
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getUserInfoListTest() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);

        List<UserInfo> userInfoList = mapper.getUserInfoList();
        System.out.println(userInfoList);

        // 提交并关闭 SqlSession
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 测试 - 注解查询
     */
    @Test
    public void getUserInfoListAOPTest() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);

        List<UserInfo> userInfoList = mapper.getUserInfoListAOP();
        System.out.println(userInfoList);

        // 提交并关闭 SqlSession
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getUserInfoLikeTest() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);

        List<String> userInfoList = mapper.getUserInfoLike("小");
        System.out.println(userInfoList);

        // 提交并关闭 SqlSession
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void log4jTest() {
        logger.info("info");
        logger.debug("debug");
        logger.error("error!");
    }

    /**
     * 分页
     */
    @Test
    public void getUserInfoByLimitTest() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex", 0);
        map.put("pageSize", 2);

        List<UserInfo> userInfoList = mapper.getUserByLimit(map);
        for (UserInfo userInfo : userInfoList) {
            System.out.println(userInfo);
        }

        sqlSession.commit();
        sqlSession.close();
    }
}
