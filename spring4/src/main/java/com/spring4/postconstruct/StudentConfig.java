package com.spring4.postconstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean(initMethod = "init")
    public Student student(){
        return new Student();
    }
}
