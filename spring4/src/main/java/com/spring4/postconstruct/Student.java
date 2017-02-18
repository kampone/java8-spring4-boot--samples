package com.spring4.postconstruct;

import javax.annotation.PostConstruct;

public class Student {

    @PostConstruct
    public void sayHello(){
        System.out.println("I am student");
    }

    public void init(){
        System.out.println("I am init");
    }

    @PostConstruct
    public void sayHello1(){
        System.out.println("I am student once again..s");
    }


}
