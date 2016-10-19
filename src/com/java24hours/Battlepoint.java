package com.java24hours;

import java.awt.*;
import java.util.*;

public class Battlepoint {
    ArrayList<Point> targets = new ArrayList<Point>();
    
    public Battlepoint() {
        //create targets to shoot at
        createTargets();
        //show the map
        showMap();
        //shoot at three points
        shoot(7,4);
        shoot(3,3);
        shoot(9,2);
        //display the new map
        showMap();
    }
    private void showMap() {
        System.out.println("\n 1 2 3 4 5 6 7 8 9");
        for (int col = 1; col < 10; col++) {
            for (int row = 0; row < 10; row++) {
                if (row == 1) {
                    System.out.println(col + " ");
                }
                System.out.print(" ");
                Point cell = new Point(row, col);
                if (targets.indexOf(cell) > -1) {
                    //a target is at this position
                    System.out.print("X");
                } else {
                    //no target here
                    System.out.print(".");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private void createTargets() {
        Point p1 = new Point(5,9);
        targets.add(p1);
        Point p2 = new Point(4,5);
        targets.add(p2);
        Point p3 = new Point(9,2);
        targets.add(p3);
    }
    private void shoot(int x, int y) {
        Point shot = new Point(x,y);
        System.out.print("firing at (" + x + ", " + y + ")...");
        if (targets.indexOf(shot) > -1) {
            System.out.println("You sank my battlepoint!");
            targets.remove(shot);
        } else {
            System.out.println("miss.");
        }
    }
    public static void main(String[] args) {
        new Battlepoint();
    }
}