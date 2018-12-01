/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch17;

import java.util.Scanner;

/**
 *
 * @author Piet
 */
public class TiltedIntuition {

    public static char selection;
    public static String quitting = "you dun son";
    public static String errorMessage = "THAAAAATSS A MAAINNNNN WRRRRAAAAAPPPPPPPPPPPP";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            do {
                showMenu();
                String menu = in.nextLine();
                System.out.println("menu choice was " + (menu.length()));
                if (menu.length() > 0) {
                    selection = menu.toLowerCase().charAt(0); // extract the first char of the line read
                } else {
                    selection = '\0';
                    System.out.println("invalid input:\t" + selection);
                    selection = 'q';
                    break;
                }

                switch (selection) {
                    case 'f':
                        FuelConsole fuelObject = new FuelConsole();
                        fuelObject.fuelCalc();
                        break;
                    case 'g':
//                        GameConsole gameObject = new GameConsole();
//                        gameObject.gameCalc();
                        break;
                    case 'q':
                        System.out.println("\nEnding Now\n");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Instruction is invalid");
                        System.in.read();

                }
            } while (selection != 'Q' && selection != 'q');
            {
                System.out.println(quitting);
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println(errorMessage);
            e.printStackTrace();

        }
    }
    
    private static void showMenu() {
        System.out.println("input something. aub...");
    }
}

class FuelConsole {
 
    public static String errorMessage = "THAAAAATSS A fuel calc WRRRRAAAAAPPPPPPPPPPPP";
    public static Double acceptableCentsPerLitre = 16.00;
 
    public void fuelCalc() {
 Scanner scan = new Scanner(System.in);
//        try (Scanner scan = new Scanner(System.in)) {
            try { 
            System.out.println("\nyou selected option 'f' --- here you will enter some information and find average fuel for ONE trip. ");
            System.out.println("\nYou must enter some information. Please read instructions carefully.");
 
            System.out.println("please enter the amount of fuel in litres:\n ");
            float fuel = scan.nextFloat();
 
            System.out.println("please enter the price of fuel in cents (not dollars and cents, only CENTS (lulz)):\n ");
            int cent = scan.nextInt();
 
            System.out.println("please enter the number of kilometers travelled on the tank:\n ");
            float kilo = scan.nextFloat();
 
            float returnAFC = afc(fuel, kilo);
            float returnAC = ac(returnAFC, cent);
 
            System.out.println("average consumption: \t" + returnAFC);
            System.out.println("average cost: \t\t" + returnAC);
            if (returnAC > acceptableCentsPerLitre) {
                System.out.println("Average fuel is above 16c per litre");
//                int b = System.in.read();
//                System.out.println("S.i.r gives " + (char) b);
scan.nextLine();
            } else {
                System.out.println("Average fuel is below 16c per litre");
//                int b = System.in.read();
scan.nextLine();
//                System.out.println("S.i.r gives " + (char) b);
            }
 
        } catch (Exception e) {
            System.out.println(errorMessage);
            e.printStackTrace();
 
        }
 
    }
 
    public static float afc(float x, float z) {
        float result = x / z;
        return result;
    }
 
    public static float ac(float x, int y) {
        float result = x * y;
        return result;
    }
}
