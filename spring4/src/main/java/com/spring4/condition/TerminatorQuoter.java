package com.spring4.condition;


import org.springframework.stereotype.Component;

@Component
@War(false)
public class TerminatorQuoter implements Quoter {

    @Override
    public void sayQuote() {
        System.out.println("I'll be back");
    }

}
