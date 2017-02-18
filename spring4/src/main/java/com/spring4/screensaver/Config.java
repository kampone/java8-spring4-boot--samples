package com.spring4.screensaver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.awt.*;
import java.util.Random;


@Configuration
public class Config {
    @Bean
    @Scope("periodical")
    public Color color(){
        Random random = new Random();
        return new Color(random.nextInt(255),
                random.nextInt(255),
                random.nextInt(255));
    }

    @Bean
    public ColorFrame frame(){
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                return color();
            }
        };
    }
}
