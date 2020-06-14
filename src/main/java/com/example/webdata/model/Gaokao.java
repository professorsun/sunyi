package com.example.webdata.model;

import lombok.Data;

import java.io.Serializable;

/**
 * (Gaokao)实体类
 *
 * @author makejava
 * @since 2020-03-17 09:42:01
 */
@Data
public class Gaokao {
    
    private Integer code;
    
    private Integer scid;
    
    private Integer sid;
    
    private Integer average;
    
    private Integer year;
    
    private Integer min;
    
    private Integer school_id;
    
    private Integer min_section;
    
    private Integer max;
    
    private String local_province_name;
    
    private String local_batch_name;
    
    private String spname;
    
    private String name;
    
    private String local_type_name;
    
    private Integer rank;
    
    private String proscore;
    
    private String areaname;
    
    private Integer is985;
    
    private Integer is211;
    
    private Integer isDoubleFirstClass;
    
    private String type;

    private Profession profession;


}