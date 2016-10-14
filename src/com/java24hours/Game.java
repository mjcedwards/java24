package com.java24hours;

class Game {
    public static void main(String[] arguments) {
        int total = 0,
                score = 7;
        if (score ==7) {
            System.out.println("You score a touchdown!");
        }
        if (score ==3) {
            System.out.println("You kick a field goal!");
        }
        total = total + score;
        System.out.println("Total score: " + total);
        char grade = 'A';
        
        switch (grade) {
            case 'A':
                System.out.println("You got an A. Awesome!");
                break;
            case 'B':
                System.out.println("You go a B. Not bad!");
                break;
            case 'C':
                System.out.println("You got a C. Meh");
                break;
            case 'D':
                System.out.println("You got a D. Disappointing");
                break;
            default:
                System.out.println("You got an F. See me after class");
                break;
        }
    }
    
}