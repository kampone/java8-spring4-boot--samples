package com.spring4.condition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuoterController {

    @Autowired
    private Quoter quoter;

    @RequestMapping("/condition")
    public String sayQuote(){
        quoter.sayQuote();
        return "finish";
    }
}
