package com.example.webdata.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

//@Data
//public class School {
//    private int id;
//    private String name;
//    private int areaId;
//
//    //关联专业
//    private List<Profession> professions;

/**
 * (School)实体类
 *
 * @author makejava
 * @since 2020-03-17 09:25:34
 */
@Data
public class School{

    private Integer rank;

    private Integer scid;

    private String name;

    private String areaname;

    private Integer areaid;

    private String description;

    private String acronym;

    private String region;

    private Integer reid;

    private String usedname;

    private String type;

    private Integer foundingYear;

    private String department;

    private String iscombine;

    private Integer is985;

    private Integer is211;

    private Integer isDoubleFirstClass;

    private Integer firstClassNum;

    private Integer facultyNum;

    private Integer academicianNum;

    private Integer changjiangScholarNum;

    private Integer teachersNum;

    private Integer undergraProNum;

    private Integer postgraProNum;

    private Integer doctorProNum;

    private Integer mainLabNum;

    private Integer undergraEnrollNum;

    private Integer postgraEnrollNum;

    private String schoolWeb;

    private List<Profession> professions;


}

