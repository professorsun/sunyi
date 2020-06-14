package com.example.webdata.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List exclude = new ArrayList();//不拦截的列表
        exclude.add("/login");
        exclude.add("/index.html");
        exclude.add("/find");
        exclude.add("/profession");
        exclude.add("/register");
        exclude.add("/userlogin");
        exclude.add("/adduser");
        exclude.add("/front/logout");
        exclude.add("/front/**");
        exclude.add("/css/**");
        exclude.add("/images/**");
        exclude.add("/fonts/**");
        exclude.add("/js/**");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns(exclude);
//        registry.addInterceptor(new VipInterceptor()).addPathPatterns("/highSearch/**");
    }
}
