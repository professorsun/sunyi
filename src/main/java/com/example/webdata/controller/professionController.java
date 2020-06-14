package com.example.webdata.controller;

import com.example.webdata.mapper.ProfessionMapper;
import com.example.webdata.model.Gaokao;
import com.example.webdata.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class professionController {
    @Autowired
    private ProfessionMapper professionMapper;
//    @Autowired
//    private SchoolMapper schoolMapper;
    @GetMapping("/find")
    @RequestMapping("/find")
    public String find(){
        return "find";
    }



    //传入学校名称查询该学校所开设的专业
    @RequestMapping("/profession")
    public String getProDataBySchname(HttpServletRequest request, Model model){
        String schoolName = request.getParameter("schoolName");
//        List<School> proBySchname = professionMapper.getProBySchname(schoolName);
        List<School> proBySchname = professionMapper.getProBySchname(schoolName);
        if(proBySchname!=null){
            model.addAttribute("proBySchname",proBySchname);
            System.out.println(proBySchname);
        }else{
            System.out.println("nnnnnnnnnnnnnnnnnnnnn");
        }


        return "find";
    }


    //传入学校名称，查询该学校历年分数线及专业数据
    @RequestMapping("/proData")
    public String getProData(HttpServletRequest request, Model model){
        String schoolName = request.getParameter("schoolName");
        List<Gaokao> proDataBySchname = (List<Gaokao>) professionMapper.getProDataBySchname(schoolName);
        model.addAttribute("proDataBySchname",proDataBySchname);
        return "";
    }




}
