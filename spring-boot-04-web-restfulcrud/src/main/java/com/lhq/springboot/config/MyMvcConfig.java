package com.lhq.springboot.config;

import com.lhq.springboot.component.LoginHandlerInterceptor;
import com.lhq.springboot.component.MyLocalResolver;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//使用WebMvcConfigurer可以来扩展SpringMVC的功能
//@EnableWebMvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送 /atLhq请求来到 success
        registry.addViewController("/atLhq").setViewName("success");
    }

//    所有的WebMvcConfigurer都会一起起作用
    @Bean//将组件注册在容器中
    public WebMvcConfigurer myMvcConfig1(){
        WebMvcConfigurer index = new WebMvcConfigurer() {
            public void addViewControllers(ViewControllerRegistry registry) {
                //浏览器发送 /atLhq请求来到 success
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
              //静态资源；*.css，*.js
             //SpringBoot已经做好了静态资源映射
               registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
                       excludePathPatterns("/index.html","/","/user/login","/asserts/**","/webjars/**","/resources/**","/hello");
                 }
             };
        return index;
    }
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }

}
