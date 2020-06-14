package com.example.webdata.controller;

import com.example.webdata.model.User;
import com.example.webdata.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class loginController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/login")
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/index")
    @RequestMapping("/index")

    public String index(HttpServletRequest request,
                        HttpServletResponse response,
                        Map<String,Object> map){
        HttpSession session=request.getSession();
        Cookie[] cookies = request.getCookies();  //获取客户端所有cookie
        for (Cookie cookie:cookies){
           if(cookie.getValue().equals(session.getId())) {
//               Object attribute = session.getAttribute(cookie.getValue());
//               String s = attribute.toString();
               map.put("msg","legal user");

            }
        }

        return "index";
    }
    @RequestMapping("/getallusers")
    public String getallusers(HttpServletRequest request, Map<String,Object> map, Model model){

        List<User> userlist = userMapper.getallusers();
       model.addAttribute("userlist",userlist);
       map.put("msg2",userlist);
        return "index";

    }
    @RequestMapping("/userlogin")
    public String userlogin(HttpServletRequest request,
                            HttpServletResponse response,
                            Map<String,Object> map
    ){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session=request.getSession();

        User verifyuser = userMapper.verifyuser(username, password);
        if(verifyuser!=null){

            String token= UUID.randomUUID().toString();
            verifyuser.setToken(token);
            userMapper.update(verifyuser);

            Cookie  c1=new Cookie("token",token);
            Cookie  c2=new Cookie(token,verifyuser.getUsername());
            c2.setMaxAge(60*60*24);
            response.addCookie(c1);
            response.addCookie(c2);
            session.setAttribute("loginUser",verifyuser.getUsername());
            Cookie[] cookies = request.getCookies();  //获取客户端所有cookie
            for (Cookie cookie:cookies){
                System.out.println(cookie.getName()+":"+cookie.getValue()+"<br/>");
            }


            int maxAge = c1.getMaxAge();



            map.put("msg",session.getId());
            map.put("msg2",verifyuser.getToken());
            return "index";
        }else{
            map.put("msg","非法用户，请核对用户名和密码");

            return "login";

        }


    }
}
