/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch17;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Piet
 */
public class JenLawrence {

}

class GuessingGames {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int computerGames = 0;
        int computerTotalGuesses = 0;
        int playerGames = 0;
        int playerTotalGuesses = 0;
        int computerTries = 0;
        boolean done = false;
        while (!done) {
            GuessingGames game = new GuessingGames();
            //Begin game by prompting player for a selection
            System.out.println("Enter 1 for the computer to guess a number you are thinking of.\n"
                + "Enter 2 to guess a number the computer is thinking of.\n"
                + "Enter 3 for statistics.\n"
                + "Enter 4 to Quit.\n");

            int selection = in.nextInt();
            switch (selection) {
                case 4:
                    done = true;
                    System.out.println("Thank You for Playing!");
                    break;
                case 1:
                    computerTotalGuesses = computerTotalGuesses + game.guessNumber();
                    computerGames++;
                    break;
                case 2:
                    playerTotalGuesses += game.playerGuess();
                    playerGames++;
                    break;
                case 3:
                    System.out.println("Still Working on Stats...");

                    System.out.println("Total Computer Guess Games: " + computerGames);
                    System.out.println("computer average nr of guesses: " + 1.0 * computerTotalGuesses / computerGames);
                    System.out.println("Total Player Guess Games: " + playerGames);
                    System.out.println("player average nr of guesses: " + 1.0 * playerTotalGuesses / playerGames);
                    break;
            }
        }

    }

    public int guessNumber() {
        Scanner in = new Scanner(System.in);

        Random rand = new Random();
        int randNum = 0;
        int high = 10;   // to test quickly if the code is working as it should
        int low = 1;
        int computerTries = 1;

        // Generate random number between 1 and 500
        randNum = rand.nextInt(high - low + 1) + low;
        String answer = "";
        System.out.println("Is it:" + randNum);
        System.out.println("Enter high or low ");
        answer = in.nextLine();
        do {

            if (answer.equals("low")) {
                low = randNum + 1;
                randNum = rand.nextInt(high - low + 1) + low;
                System.out.println("Is it:" + randNum);
                System.out.println("Enter high or low ");
                answer = in.nextLine();
                computerTries++;
            } else if (answer.equals("high")) {
                high = randNum - 1;
                randNum = rand.nextInt(high - low + 1) + low;
                System.out.println("Is it:" + randNum);
                System.out.println("Enter high or low ");
                answer = in.nextLine();
                computerTries++;
            }
        } while (!answer.equals("correct"));
        System.out.println("Computer tries: " + computerTries);
        return computerTries;
    }

    public int playerGuess() {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        int secretNum = 0;
        int high = 10;    // to test quickly if the code is working as it should
        int low = 1;

        //Generate a random number between 1 and 500 (10 currently)
        secretNum = rand.nextInt(high - low + 1) + low;
        int playerGuess = 0;
        int playerTries = 1;
        System.out.println("Enter Guess:");
        playerGuess = in.nextInt();
        do {
            if (playerGuess > secretNum) {
                System.out.println("Too High");
                playerTries++;
                playerGuess = in.nextInt();
            } else if (playerGuess < secretNum) {
                System.out.println("Too Low");
                playerTries++;
                playerGuess = in.nextInt();
            }

        } while (playerGuess != secretNum);
        System.out.println("Correct! The number was: " + secretNum);
        System.out.println("Player Tries: " + playerTries);
        return playerTries;
    }

    public void Statistics() {

    }

}
