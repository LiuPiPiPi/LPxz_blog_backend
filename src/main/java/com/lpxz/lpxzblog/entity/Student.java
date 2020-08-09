package com.lpxz.lpxzblog.entity;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    private int tId;
    private Teacher teacher;
}
