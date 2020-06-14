package com.example.webdata.controller;

import com.example.webdata.model.User;
import com.example.webdata.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
public class registerController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/register")
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    @RequestMapping("/adduser")
    public String adduser(HttpServletRequest request, Map<String,Object> map){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        User checkusername = userMapper.checkusername(username);
        if(checkusername!=null){
            map.put("msg","该用户名已被注册，请重新申请");
            return "register";
        }else{
            userMapper.adduser(user);
            map.put("msg",user);
            return "login";
        }







    }
}
