package com.java24hours;

class Wheel {
    public static void main(String[] args) {
        String[] phrase = {
          "A STITCH IN TIME SAVES NINE",
            "DON'T EAT YELLOW SNOW",
            "JUST DO IT",
            "I WANT MY MTV",
            "I LIKE IKE",
            "EVERY GOOD BOY DOES FINE",
            "PLAY IT AGAIN SAM",
            "FROSTY THE SNOWMAN",
            "ONE MORE FOR THE ROAD",
            "HOME FIELD ADVANTAGE",
            "VALENTINES DAY MASSACRE",
            "GOVER CLEVELAND OHIO",
            "SPAGHETTI WESTERN",
            "AQUA TEEN HUNGER FORCE",
            "IT'S A WONDERFUL LIFE"
        };
        int[] letterCount = new int[26];
        for (int i = 0; i < phrase.length; i++) {
            String j = phrase[i];
            char[] letters = j.toCharArray();
            for (int k = 0; k < letters.length; k++) {
                char letter = letters[k];
                if ((letter >= 'A') & (letter <= 'Z')) {
                letterCount[letter - 'A']++;
            }
                
            }
            
        }
        for (char count = 'A'; count <= 'Z'; count++) {
            System.out.print(count + ": " + 
                    letterCount[count - 'A'] + " ");
            if (count == 'M') {
                System.out.println();
            }
            
        }
        System.out.println();
    }
}