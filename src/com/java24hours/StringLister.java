package com.java24hours;

import java.util.ArrayList;
import java.util.Collections;

public class StringLister {
    String[] names = { "Spanky", "Alfalfa", "Buckwheat", "Daria", "Stymie", "Marianne",
    "Scotty", "Tommy", "Chubby"};
    
    public StringLister(String[] moreNames) {
        ArrayList<String> list = new ArrayList<String>();
        for (String name : names) {
            list.add(name);
        }
        for (String name : moreNames) {
            list.add(name);
        }
        Collections.sort(list);
        for (String name : list) {
            System.out.println(name);
        }
        
    }
    public static void main(String[] args) {
        StringLister lister = new StringLister(args);
        
    }
}