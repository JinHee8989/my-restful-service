package com.example.myrestfulservices;

import com.sun.corba.se.spi.resolver.LocalResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class MyRestfulServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyRestfulServicesApplication.class, args);
    }


    @Bean //SpringBootApplication가 실행될때 해당 빈이 메모리에 올라가게됨
    public SessionLocaleResolver localResolver(){
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.KOREA);
        return localeResolver;
    }
}
