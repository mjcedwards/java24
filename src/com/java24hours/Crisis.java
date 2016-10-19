package com.java24hours;

import java.awt.*;
import javax.swing.*;

public class Crisis extends JFrame {
    JButton panicButton;
    JButton dontPanicButton;
    JButton blameButton;
    JButton mediaButton;
    JButton saveButton;
    
    public Crisis() {
        super("Crisis");
        setLookAndFeel();
        setSize(348,128);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flow = new FlowLayout();
        setLayout(flow);
        panicButton = new JButton("PANIC!");
        dontPanicButton = new JButton("Don't Panic");
        blameButton = new JButton("Blame others");
        mediaButton = new JButton("notify the media");
        saveButton = new JButton("Save yourself");
        
        add(panicButton);
        add(dontPanicButton);
        add(blameButton);
        add(mediaButton);
        add(saveButton);
        setVisible(true);
        
    }
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.jva.swing.plaf.numbus.Nimbus-LookAndFeel");
        } catch (Exception exc) {
            //ignore error
        }
    }
    public static void main(String[] args) {
        Crisis frame = new Crisis();
    }
}
