package com.java24hours;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewKeyViewer extends JFrame {
    JTextField keyText = new JTextField(80);
    JLabel keyLabel = new JLabel("Press any key in the text field");
    
    public NewKeyViewer() {
        super("NewKeyViewer");
        setLookAndFeel();
        setSize(350, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        keyText.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent input) {
                char key = input.getKeyChar();
                keyLabel.setText("You pressed " + key);
            }
        });
        BorderLayout bord = new BorderLayout();
        setLayout(bord);
        add(keyLabel, BorderLayout.NORTH);
        add(keyText, BorderLayout.CENTER);
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
        new NewKeyViewer();
    }
}