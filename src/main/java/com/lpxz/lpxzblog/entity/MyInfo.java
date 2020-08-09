package com.lpxz.lpxzblog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 个人信息
 *
 * @author liu
 * @version 2020/07/31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyInfo {
    /**
     * 名字（LPxz，LP学长）
     */
    private final String[] names = {
            "LPxz",
            "LP学长"
    };

    /**
     * 真名（刘碧豪）
     */
    private final String realName = "刘碧豪";

    /**
     * 性别
     */
    private final String sex = "男";

    /**
     * 年龄
     */
    private int age;

    /**
     * 头像
     */
    private String avatarUrl;

    /**
     * Github 个人页面地址
     */
    private final String githubUrl = "https://github.com/LiuPiPiPi";

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 大学
     */
    private final String college = "西北工业大学";

    /**
     * 学院
     */
    private final String institute = "软件学院";

    /**
     * 专业
     */
    private final String major = "软件工程";

    /**
     * 职业
     */
    private String[] jobs;

    /**
     * 技术
     */
    private String[] skills;


}
