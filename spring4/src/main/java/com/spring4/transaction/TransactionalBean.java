package com.spring4.transaction;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;


@Transactional(propagation = Propagation.REQUIRES_NEW)
@Controller
public class TransactionalBean {

    public void sayMessage(String message){
        System.out.println(message);
    }

    @RequestMapping("/transactional")
    public String sayHello(){
        sayMessage("Hello");
        return HttpStatus.OK.toString();
    }
}
