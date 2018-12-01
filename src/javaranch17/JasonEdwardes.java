/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch17;

import java.util.Random;

/**
 *
 * @author Piet
 */
public class JasonEdwardes {

}

class MainClass {

    private Integer leftWheel, middleWheel, rightWheel;
    //game loop points
    private int points = 301;
    private boolean gameloop = true;
    private int lineNumber = 0;
    // number of random numbers
    private int range = 10;

    public static void main(String[] args) {
        new MainClass().rollNumber();
    }

    private void rollNumber() {
        System.out.print(" lineNumber    wheelLeft   middleWheel   rightWheel    Score   ");
        System.out.println();
        while (gameloop) {
            GetRandomNumber randomLeftWheelNumber = new GetRandomNumber();
            GetRandomNumber randomMiddleWheelNumber = new GetRandomNumber();
            GetRandomNumber randomRightWheelNumber = new GetRandomNumber();
            leftWheel = randomLeftWheelNumber.GetRandom(range);
            middleWheel = randomMiddleWheelNumber.GetRandom(range);
            rightWheel = randomRightWheelNumber.GetRandom(range);
 
            System.out.format("(%d, %d, %d, %s)", leftWheel, middleWheel, rightWheel, leftWheel == middleWheel ? "points" : "nothing");
            if (leftWheel.equals(middleWheel) && middleWheel.equals(rightWheel)) {
                System.out.print(("     " + (lineNumber += 1)));
                points += 15;
                System.out.print("                                 win 15 points ");
                System.out.println("    " + (points));
            } else if (leftWheel.equals(middleWheel)) {
                System.out.print(("     " + (lineNumber += 1)));
                points += 4;
                System.out.print("                                 win 4 points ");
                System.out.println("    " + (points));
            } else {
                points -= 1;
                System.out.print(("     " + (lineNumber += 1)));
                System.out.print("            " + leftWheel);
                System.out.print("            " + middleWheel);
                System.out.print("            " + rightWheel);
                System.out.println("           " + (points));
                if (points < 1) {
                    gameloop = false;
                    System.out.println("game over");
                }
            }

        }
    }
}

class GetRandomNumber {

    // random number
    private int ranNumber;
    private Random random;
    private Integer number;

    // getNumber = random maxim number
    public Integer GetRandom(int getNumber) {

        //new random object
        random = new Random();
        ranNumber = random.nextInt(getNumber);
        // wrap int into a object
        number = ranNumber;
        // return the random number
        return number;
    }
}
