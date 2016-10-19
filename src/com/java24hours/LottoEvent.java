package com.java24hours;

import javax.swing.*;
import java.awt.event.*;

public class LottoEvent implements Runnable {
    LottoMadness gui; //declares
    Thread playing; //creates a thread (operation)
    
    public LottoEvent(LottoMadness in) {
        gui = in; // sets the instance of LottoMadness to the argument "in"
    }
    ActionListener act = (event) -> {
        String command = event.getActionCommand(); //creates a string that stores 
        //info about which button is pressed and what method to call in each case
        if (command.equals("Play")) {
            startPlaying();
        }
        if (command.equals("Stop")) {
            stopPlaying();
        }
        if (command.equals("Reset")) {
            clearAllFields();
        }
    };
//    public void actionPerformed(ActionEvent event) {
//        String command = event.getActionCommand(); //creates a string that stores 
//        //info about which button is pressed and what method to call in each case
//        if (command.equals("Play")) {
//            startPlaying();
//        }
//        if (command.equals("Stop")) {
//            stopPlaying();
//        }
//        if (command.equals("Reset")) {
//            clearAllFields();
//        }
//    }
    void startPlaying() {
        playing = new Thread(this); //instanciates a new Thread object
        playing.start(); //starts the thread
        gui.play.setEnabled(false); //disables the play button while thread is active
        gui.stop.setEnabled(true); //enables stop button while thread is active
        gui.reset.setEnabled(true); //enables reset button while thread is active
        gui.quickpick.setEnabled(false); //disables the checkboxes while thread is active
        gui.personal.setEnabled(false);    
    }
    void stopPlaying() {
        gui.stop.setEnabled(false); //disables the stop button when it is pressed
        gui.play.setEnabled(true); //enables the play button when thread is stopped
        gui.reset.setEnabled(true); //enables reset button when thread is stopped
        gui.quickpick.setEnabled(true); //enables checkboxes when thread is stopped
        gui.personal.setEnabled(true);
        playing = null; // stops the "playing" thread
    }
    void clearAllFields() {
        for (int i = 0; i < 6; i++) {
            gui.numbers[i].setText(null); // sets personal numbers to NULL
            gui.winners[i].setText(null); // sets winning numbers to NULL
        }
        gui.got3.setText("0"); // sets all the matched fields to "0"
        gui.got4.setText("0");
        gui.got5.setText("0");
        gui.got6.setText("0");
        gui.drawings.setText("0");
        gui.years.setText("0");
    }
    ItemListener item = (event) -> {
        Object item = event.getItem();
        if (item == gui.quickpick) {
            for (int i = 0; i < 6; i++) {
                int pick; //creates a pick integer, which randomly generates a number 1-50
                do {
                    pick = (int) Math.floor(Math.random() * 50 + 1);
                } while (numberGone(pick, gui.numbers, i));
                gui.numbers[i].setText("" + pick); //changes the text field to show the number
            }
            
        } else {
            for (int k = 0; k < 6; k++) {
                gui.numbers[k].setText(null);
            }
        }
    };
//    public void itemStateChanged(ItemEvent event) {
//        Object item = event.getItem();
//        if (item == gui.quickpick) {
//            for (int i = 0; i < 6; i++) {
//                int pick; //creates a pick integer, which randomly generates a number 1-50
//                do {
//                    pick = (int) Math.floor(Math.random() * 50 + 1);
//                } while (numberGone(pick, gui.numbers, i));
//                gui.numbers[i].setText("" + pick); //changes the text field to show the number
//            }
//            
//        } else {
//            for (int k = 0; k < 6; k++) {
//                gui.numbers[k].setText(null);
//            }
//        }
//    }
    void addOneToField(JTextField field) {
        int num = Integer.parseInt("0" + field.getText());
        num ++;
        field.setText("" + num); //adds one to the matched fields
    }
    boolean numberGone(int num, JTextField[] pastNums, int count) {
        for (int i = 0; i < count; i++) {
            if (Integer.parseInt(pastNums[i].getText()) == num) {
                return true; //makes sure the same number can't be picked twice
            }
        }
        return false;
    }
    boolean matchedOne(JTextField win, JTextField[] allPicks) { 
        for (int i = 0; i < 6; i++) {
            String winText = win.getText(); 
            if (winText.equals(allPicks[i].getText())) {
                return true; // returns true if any numbers match winning numbers
            }
        }
        return false;
    }
    public void run() {
        Thread thisThread = Thread.currentThread();
        while (playing == thisThread) {
            addOneToField(gui.drawings);
            int draw = Integer.parseInt(gui.drawings.getText());
            float numYears = (float) draw / 104;
            gui.years.setText("" + numYears); //sets number of years based on drawings
            
            int matches = 0;
            for (int i = 0; i < 6 ; i++) {
                int ball;
                do {
                    ball = (int) Math.floor(Math.random() * 50 + 1); // determines winning numbers
                } while (numberGone(ball, gui.winners, i));
                gui.winners[i].setText("" + ball);
                if (matchedOne(gui.winners[i], gui.numbers)) {
                    matches++;
                }
            }
            switch (matches) {
                case 3:
                    addOneToField(gui.got3);
                    break;
                case 4:
                    addOneToField(gui.got4);
                    break;
                case 5: 
                    addOneToField(gui.got5);
                    break;
                case 6: 
                    addOneToField(gui.got6);
                    gui.stop.setEnabled(false);
                    gui.play.setEnabled(true);
                    playing = null; // if 6 matches, ends thread
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                //do nothing
            }
        }
    }
}