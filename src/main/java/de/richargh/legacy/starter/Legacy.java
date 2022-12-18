package de.richargh.legacy.starter;

import java.util.Random;

public class Legacy {

    private int mode;

    private String state;

    public static Random rand = new Random();

    public void doSth(String tmp, boolean flag){
        // imagine this method does something that you don't understand

        String theResult = "";

        if(flag){
            mode = 1;
            System.out.println("Setting mode 1");
        }

        if(mode == 1){
            System.out.println("I am now in mode 1");

            if(tmp.equals("five")){
                System.out.println("You loose");
                state = "win";
            } else {
                System.out.println("You gain");
            }

            if(rand.nextInt(5) == 4){
                System.out.println("A puppy");
                state = "puppy";
            }
        }
        System.out.println("and");
        if(mode == 12){
            System.out.println("I am now in mode23");
            if(rand.nextInt(12) == 5){
                System.out.println("A tennis ball");
                state = "pupball";
            }
        }

        if(state == "puppy"){
            System.out.println("Congrautlations! You won");
        }
    }

}
