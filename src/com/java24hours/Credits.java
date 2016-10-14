package com.java24hours;

class Credits {
    public static void main(String[] arguments) {
        String title = "Sharknado";
        int year = 2013;
        String director = "Anthony Ferrante",
                role1 = "Fin",
                actor1 = "Ian Ziering",
                role2 = "April",
                actor2 = "Tara Reid",
                role3 = "George",
                actor3 = "John Heard",
                role4 = "Nova",
                actor4 = "Cassie Scerbo";
        System.out.println(title
                + " (" 
                + year
                + ")\n\n"
                + "An " + director + " Film\n"
                + role1 + "\t" + actor1 +"\n"
                + role2 + "\t" + actor2 +"\n"
                + role3 + "\t" + actor3 +"\n"
                + role4 + "\t" + actor4);
                
    }
}