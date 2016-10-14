package com.java24hours;

import javax.swing.*;
import java.awt.*;

public class GUIExamples extends JFrame {
    public GUIExamples() {
        super("GUI Examples");
        setLookAndFeel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flo = new FlowLayout();
        setLayout(flo);
        JButton play = new JButton("Play");
        JButton stop = new JButton("Stop");
        JButton pause = new JButton("Pause");
        JLabel pageLabel = new JLabel("Web page address:", JLabel.LEFT);
        JTextField pageAddress = new JTextField(20);
        JCheckBox jumboSize = new JCheckBox("Jumbo Size");
        add(jumboSize);
        add(pageLabel);
        add(pageAddress);
        add(play);
        add(pause);
        add(stop);
        pack();
        setVisible(true);
    }
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("apple.laf.AquaLookAndFeel");
        } catch (Exception exc) {
            
        }
        
    }
    public static void main(String[] args) {
        GUIExamples frame = new GUIExamples();
    }
}