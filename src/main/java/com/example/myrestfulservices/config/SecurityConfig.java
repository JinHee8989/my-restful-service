package com.example.myrestfulservices.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration //메모리에 설정정보 로드함
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Kenneth")
                .password("{noop}test1234") //{noop} = no option이라는뜻. 기타 동작없이 인코딩 안해도 기능하도록
                .roles("USER");
    }
}
