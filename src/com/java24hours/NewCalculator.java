package com.java24hours;

public class NewCalculator {
    public static void main(String[] args) {
        float sum = 0;
        for (String arg : args) {
            try {
                sum += Float.parseFloat(arg);
            } catch (NumberFormatException e) {
                System.out.println(arg + " is not a number");
            }
        }
        System.out.println("Those numbers add up to " + sum);
    }
}