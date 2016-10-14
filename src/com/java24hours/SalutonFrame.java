package com.java24hours;

import javax.swing.*;

public class SalutonFrame extends JFrame {
    public SalutonFrame() {
        super("Saluton Mondo!");
        setLookAndFeel();
        setSize(350,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton okButton = new JButton("OK");
        add(okButton);
        setVisible(true);



    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("apple.laf.AquaLookAndFeel");
        } catch (Exception exc) {
            //ignore error
        }
    }
    public static void main(String[] args) {
        SalutonFrame frame = new SalutonFrame();

    }
    
}
