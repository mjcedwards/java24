package com.java24hours;

import java.io.*;
import java.util.*;

public class Configurator {
    public Configurator() {
        try {
            //load properties file
            File configFile = new File("program.properties");
            FileInputStream inStream = new FileInputStream(configFile);
            Properties config = new Properties();
            config.load(inStream);
            // create a new property
            Date current = new Date();
            
            config.setProperty("runtime", current.toString());
            //save the properties file
            FileOutputStream outStream = new FileOutputStream(configFile);
            config.store(outStream, "Properties settings");
            inStream.close();
            config.list(System.out);
        } catch (IOException ioe) {
            System.out.println("IO Error -- " + ioe.getMessage());
        }
    }
    public static void main(String[] args) {
        Configurator con = new Configurator();
    }
}