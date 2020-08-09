package com.lpxz.lpxzblog.dao;

import com.lpxz.lpxzblog.entity.UserInfo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserInfoMapper {
    // 根据 id 查询用户信息
    UserInfo getUserInfoById(int id);

    // 根据 id 查询用户信息 注解方式
    // 有两个参数时，(@Param("id") int id, @Param("name") String name)
    @Select("select * from user_info where id = #{id}")
    UserInfo getUserInfoByIdAOP(@Param("id") int id);

    // 查询全部用户信息
    List<UserInfo> getUserInfoList();

    // 查询全部用户信息 注解方式
    @Select("select * from user_info")
    List<UserInfo> getUserInfoListAOP();

    // 更新用户信息
    void updateUserInfo(UserInfo userInfo);

    // 模糊查询示例
    List<String> getUserInfoLike(String name);

    // Limit 分页查询
    List<UserInfo> getUserByLimit(Map<String, Integer> map);
}