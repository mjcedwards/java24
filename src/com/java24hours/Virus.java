package com.java24hours;

public class Virus {
    static int virusCount = 0;
    private int newSeconds;
    public Virus(){
        virusCount++;
    }
    static int getVirusCount(){
        return virusCount;
    }
    void setSeconds(int newSeconds) {
        if (newSeconds > 60 & newSeconds < 100) {
            this.newSeconds = newSeconds;
        }
    }
    int getSeconds() {
        return this.newSeconds;
    }
}