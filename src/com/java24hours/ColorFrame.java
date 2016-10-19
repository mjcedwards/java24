package com.java24hours;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ColorFrame extends JFrame {
    JButton red, green, blue;
    
    public ColorFrame() {
        super("ColorFrame");
        setLookAndFeel();
        setSize(322,122);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flow = new FlowLayout();
        setLayout(flow);
        red = new JButton("Red");
        blue = new JButton("Blue");
        green = new JButton("Green");
        add(red);
        add(green);
        add(blue);
        //begin anonymous inner class
        ActionListener act = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (event.getSource() == red) {
                    getContentPane().setBackground(Color.RED);
                }
                if (event.getSource() == green) {
                    getContentPane().setBackground(Color.GREEN);
                }
                if (event.getSource() == blue) {
                    getContentPane().setBackground(Color.BLUE);
                }
                
            }
        };
        //end of anonymous inner class
        red.addActionListener(act);
        green.addActionListener(act);
        blue.addActionListener(act);
        setVisible(true);
    }
    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("apple.laf.AquaLookAndFeel");
        } catch (Exception exc) {
            //ignore error
        }
    }
    public static void main(String[] args) {
        new ColorFrame();
    }
}