package com.java24hours;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewColorFrame extends JFrame  {
    JButton red, green, blue;
    
    public NewColorFrame() {
        super("NewColorFrame");
        setLookAndFeel();
        setSize(322,122);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flow = new FlowLayout();
        setLayout(flow);
        red = new JButton("Red");
        green = new JButton("Green");
        blue = new JButton("Blue");
        add(red);
        add(green);
        add(blue);
        //begin lambda function
        ActionListener act = (event) -> {
            if (event.getSource() == red) {
                    getContentPane().setBackground(Color.RED);
                }
                if (event.getSource() == green) {
                    getContentPane().setBackground(Color.GREEN);
                }
                if (event.getSource() == blue) {
                    getContentPane().setBackground(Color.BLUE);
                }
        };
        //end of lambda function
        red.addActionListener(act);
        green.addActionListener(act);
        blue.addActionListener(act);
        setVisible(true);
    }
    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("apple.laf.AquaLookAndFeel");
        } catch (Exception exc) {
            System.out.println("UI Not found");
        }
    }
    public static void main(String[] args) {
        new NewColorFrame();
    }
}
