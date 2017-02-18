package com.spring4.screensaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.*;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public abstract class ColorFrame extends JFrame {

    public ColorFrame() throws HeadlessException{
        System.out.println(GraphicsEnvironment.isHeadless());
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace() {
        Random random = new Random();
        setLocation(random.nextInt(1800), random.nextInt(1200));
        getContentPane().setBackground(getColor());
        repaint();
    }

    protected abstract Color getColor();

}
