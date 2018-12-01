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
public class SoneandPap {
    public static void main(String... args) {
        var macB = "Ff:FF:fF:FF:FF:FF";
        var macU = "0A:...";
        var macM = "1F:...";
        System.out.format("%s = %s%n", macB, determineTypeOfCast(macB));
        System.out.format("%s = %s%n", macU, determineTypeOfCast(macU));
        System.out.format("%s = %s%n", macM, determineTypeOfCast(macM));
    }
    
    public static String determineTypeOfCast(String mac) {
        var test = mac.toUpperCase();
        return test.equals("FF:FF:FF:FF:FF:FF")          ? "broadcast" :
               "02468ACE".contains(test.substring(1, 2)) ? "unicast"   :
                                                           "multicast";
    }
}
