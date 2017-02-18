package com.notemates.spring;

import org.springframework.context.support.GenericGroovyApplicationContext;


public class Main {
    public static void main(String[] args) {
        GenericGroovyApplicationContext genericGroovyApplicationContext = new GenericGroovyApplicationContext("context.groovy");
        Object student = genericGroovyApplicationContext.getBean("student");
        System.out.println(student.toString());
    }
}
