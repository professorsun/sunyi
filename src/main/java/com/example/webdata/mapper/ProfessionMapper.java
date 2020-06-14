package com.example.webdata.mapper;

import com.example.webdata.model.Gaokao;
import com.example.webdata.model.School;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProfessionMapper {
    Gaokao getProDataBySchname(String schoolName);
    School getProBySchname(String schoolName);
}
