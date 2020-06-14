package com.example.webdata.mapper;

import com.example.webdata.model.Gaokao;
import com.example.webdata.model.School;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProfessionMapper {
   List<Gaokao > getProDataBySchname(String schoolName);
    List<School> getProBySchname(String schoolName);
}
