package com.jpa.jpa.util;

import com.jpa.jpa.dao.StudentRepository;
import com.jpa.jpa.entity.Student;
import com.jpa.jpa.security.AuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Configuration
public class DataLoader {

    @Bean
    public FilterRegistrationBean<AuthenticationFilter> filterFilterRegistrationBean(){
        FilterRegistrationBean<AuthenticationFilter> registrationBean=new FilterRegistrationBean<>();
        AuthenticationFilter authenticationFilter=new AuthenticationFilter();
        registrationBean.setFilter(authenticationFilter);
        registrationBean.addUrlPatterns("/students/*");
        return registrationBean;
    }

}
