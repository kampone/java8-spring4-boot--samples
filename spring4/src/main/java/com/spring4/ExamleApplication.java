package com.spring4;

import com.spring4.ripper.RipperMain;
import com.spring4.screensaver.ScreensaverMain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.awt.*;

@SpringBootApplication
@EnableScheduling
public class ExamleApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(ExamleApplication.class, args);
		System.setProperty("java.awt.headless", "true");

		ScreensaverMain.run();
	}
}
