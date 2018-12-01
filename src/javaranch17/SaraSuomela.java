/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch17;

/**
 *
 * @author Piet
 */
public class SaraSuomela {
    public static void main(String... args) {
        int[] buildings = {1, 2, 3, 4, 5, 6};
        String[] names = new String[]{"Piet", "Piet", "Piet", "Piet", "Piet", "Piet"};
        String name = "piet";
        printBuildingNumbers(name, buildings, names);
        
    }
    public static void printBuildingNumbers(String familyName, int[] buildingNumbers, String[] names) {
        int nrOfBuildingsFound = 0;
        for (int index = 0; index < names.length; index++) {
            if (names[index].equalsIgnoreCase(familyName)) {
                System.out.println("family " + names[index] + " lives in building nr " + buildingNumbers[index]);
                nrOfBuildingsFound++;
            }
        }
        System.out.println("So, family " + familyName + " lives in " + nrOfBuildingsFound + " buildings");
    }
}
