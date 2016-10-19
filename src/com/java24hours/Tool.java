package com.java24hours;

import java.awt.*;
import javax.swing.*;

public class Tool extends JFrame {
    public Tool() {
        super("Tool");
        setLookAndFeel();
        setSize(370,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //create buttons with icons
        ImageIcon image1 = new ImageIcon("/Users/Sven/NetBeansProjects/Java24/images/cloud-check.png"); // change this to your own icon later
        JButton button1 = new JButton(image1);
        
        ImageIcon image2 = new ImageIcon("/Users/Sven/NetBeansProjects/Java24/images/cloud-down.png"); // change this to your own icon later
        JButton button2 = new JButton(image2);
        
        ImageIcon image3 = new ImageIcon("/Users/Sven/NetBeansProjects/Java24/images/cloud-error.png"); // change this to your own icon later
        JButton button3 = new JButton(image3);
        
        //build toolbar
        JToolBar bar = new JToolBar();
        bar.add(button1);
        bar.add(button2);
        bar.add(button3);
        
        //build text area
        JTextArea edit = new JTextArea(8, 40);
        JScrollPane scroll = new JScrollPane(edit);
        
        //create frame
        
        BorderLayout border = new BorderLayout();
        setLayout(border);
        add("South", bar);
        add("Center", scroll);
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
        Tool frame = new Tool();
    }
}