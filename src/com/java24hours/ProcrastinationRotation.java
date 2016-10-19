package com.java24hours;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.net.*;

public class ProcrastinationRotation extends JFrame implements Runnable, ActionListener {
    String[] pageTitle = new String[6];
    URI[] pageLink = new URI[6];
    int current = 0;
    Thread runner;
    JLabel siteLabel = new JLabel();
    public ProcrastinationRotation() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,100);
        FlowLayout flow = new FlowLayout();
        setLayout(flow);
        add(siteLabel);
        
        pageTitle = new String[] {
            "Facebook", 
            "Twitter",
            "Reddit",
            "Twitch",
            "New York Times",
            "Fantasy Sports"
        };
        pageLink[0] = getURI("http://www.facebook.com");
        pageLink[1] = getURI("http://www.twitter.com");
        pageLink[2] = getURI("http://www.reddit.com");
        pageLink[3] = getURI("http://www.twitch.tv");
        pageLink[4] = getURI("http://www.nytimes.com");
        pageLink[5] = getURI("http://fantasysports.yahoo.com");
        Button visitButton = new Button("Visit site");
        visitButton.addActionListener(this);
        add(visitButton);
        setVisible(true);
        start();
    }
    private URI getURI(String urlText) {
        URI pageURI = null;
        try {
            pageURI = new URI(urlText);;
        } catch(URISyntaxException exc) {
            //do nothing
        }
        return pageURI;
    }
    public void start() {
        if (runner == null) {
            runner = new Thread(this);
            runner.start();
        }
    }
    public void run() {
        Thread thisThread = Thread.currentThread();
        while (runner == thisThread) {
            current ++;
            if (current > 5) {
                current = 0;
            }
            siteLabel.setText(pageTitle[current]);
            repaint();
            try {
                Thread.sleep(100);
            } catch(InterruptedException exc) {
                //do nothing
            }
        }
    }
    public void actionPerformed(ActionEvent event) {
        Desktop desktop = Desktop.getDesktop();
        if (pageLink[current] != null) {
            try {
                desktop.browse(pageLink[current]);
                runner = null;
                System.exit(0);
            } catch(IOException exc) {
                //do nothing
            }
        }
    }
    public static void main(String[] args) {
        new ProcrastinationRotation();
    }
}