package com.spring4.condition;

import org.springframework.stereotype.Component;

@Component
@War(true)
public class SusaninQuoter implements Quoter {
    @Override
    public void sayQuote() {
        System.out.println("Will come in a minute");
    }
}
