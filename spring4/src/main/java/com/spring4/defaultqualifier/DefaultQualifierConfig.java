package com.spring4.defaultqualifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultQualifierConfig {

    @Bean
    public String name(){
        return "Vasya";
    }

    @Bean
    public String conference(){
        return "JPoint";
    }
}
