package com.spring4.common;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ContextHolder {

    public static ApplicationContext context;

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    private void init(){
        ContextHolder.context = applicationContext;
    }

}
