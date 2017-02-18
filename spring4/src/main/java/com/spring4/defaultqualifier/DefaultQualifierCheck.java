package com.spring4.defaultqualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class DefaultQualifierCheck {

    @Autowired
    private String conference;

    @PostConstruct
    public void check(){
        System.out.println(conference);
    }
}
