package com.spring4.screensaver;


import static com.spring4.common.ContextHolder.context;

public class ScreensaverMain {

    public static void run() throws InterruptedException {
        while (true){
            context.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(1000);
        }
    }
}
