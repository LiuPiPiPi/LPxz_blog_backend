package com.lpxz.lpxzblog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

/**
 * 博客
 *
 * @author liu
 * @version 2020/07/31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    /**
     * 博客 ID
     */
    private String id;

    /**
     * 博客标题
     */
    private String title;

    /**
     * 作者
     */
    private String author;

    /**
     * 分类标签
     */
    private String label;

    /**
     * 博客创建日期
     */
    private Date createTime;

    /**
     * 点赞数
     */
    private int likes;

    /**
     * 浏览量
     */
    private int views;

    /**
     * 评论
     */
    private String[] comments;
}
