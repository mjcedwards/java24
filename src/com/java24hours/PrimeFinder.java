package com.java24hours;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PrimeFinder extends JFrame implements Runnable, ActionListener {
    Thread go; //create a new thread
    JLabel howManyLabel; //create a label for number of primes
    JTextField howMany; //create a textfield to enter a number
    JButton display; //create a button to display the primes up to previous number
    JTextArea primes; //create a text field to display the primes
    
    public PrimeFinder() {
        super("Find Prime numbers");
        setLookAndFeel();
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        BorderLayout bord = new BorderLayout();
        setLayout(bord);
        
        howManyLabel = new JLabel("Quantity");
        howMany = new JTextField("400", 10);
        display = new JButton("Display primes");
        primes = new JTextArea(8,40);
        
        display.addActionListener(this);
        JPanel topPanel = new JPanel();
        topPanel.add(howManyLabel);
        topPanel.add(howMany);
        topPanel.add(display);
        add(topPanel, BorderLayout.NORTH);
        
        primes.setLineWrap(true);
        JScrollPane textPane = new JScrollPane(primes);
        add(textPane, BorderLayout.CENTER);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent event) {
        display.setEnabled(false);
        if (go == null) { 
            go = new Thread(this);
            go.start();
        }
    }
    public void run() {
        int quantity = Integer.parseInt(howMany.getText());
        int numPrimes = 0;
        //candidate: number that might be prime
        int candidate = 2;
        primes.append("First " + quantity + " primes:");
        while (numPrimes < quantity) {
            if (isPrime(candidate)) {
                primes.append(candidate + " ");
                numPrimes++;
        }
        candidate++;
        }
        
    }
    public static boolean isPrime(int checkNumber) {
        double root = Math.sqrt(checkNumber);
        for (int i = 2; i <= root; i++) {
            if (checkNumber % i == 0) {
                return false;
            }
        }
        return true;
    }
    private void setLookAndFeel() {
        try {
        UIManager.setLookAndFeel("apple.laf.AquaLookAndFeel");
        } catch (Exception exc) {
            //ignore error
        }
    }
    public static void main(String[] args) {
        new PrimeFinder();
    }
}

