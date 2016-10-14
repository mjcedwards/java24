package com.java24hours;

class SpaceRemover {
    public static void main(String[] arguments) {
        String mostFamous = "Rudolph the Red-Nosed Reindeer";
        char[] mfl = mostFamous.toCharArray();
        for (int i = 0; i < mfl.length; i++) {
            char c = mfl[i];
            if (c != ' ') {
                System.out.print(c);
            } else
                System.out.print(".");
            
        }
        System.out.println();
    }
}