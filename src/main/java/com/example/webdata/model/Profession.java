package com.example.webdata.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

//@Data
//public class Profession {
//    private int pid;
//    private String pname;
//
//    //关联学校_专业表，获得专业分数线
////   private List<School> schools;
//
//   private List<School_Pro> school_pro;

/**
 * (Profession)实体类
 *
 * @author makejava
 * @since 2020-03-17 09:36:15
 */
@Data
public class Profession {

    private String description;

    private String subject;

    private String major;

    private Integer pid;

    private String proname;

    private String timelength;

    private String classes;

    private String job;

    private String graduate;

    private String code;

    private String sort;

//    private List<School> schools;


}

