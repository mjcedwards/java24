package com.java24hours;

public class VirusLab {
    public static void main(String[] args) {
        int numOfViruses = Integer.parseInt(args[0]);
        if (numOfViruses > 0) {
            Virus[] virii = new Virus[numOfViruses];
            for (int i = 0; i < numOfViruses; i++) {
                virii[i] = new Virus();
            }
            System.out.println("The number of viruses is " + Virus.getVirusCount());
        }
    }
}