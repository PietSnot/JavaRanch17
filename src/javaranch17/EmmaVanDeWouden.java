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
public class EmmaVanDeWouden {
    
}

class Prime {
 
    public static void main(String[] args) {
     
    int NumberOfPrimes = 0;
    final int Limit = Integer.parseInt("100000");
    boolean[] Primes = new boolean [Limit + 1];
    for (int Tindex = 2; Tindex <= Limit; Tindex++) {
      Primes[Tindex] = true;
    } 
    for (int Tindex = 2; Tindex*Tindex <= Limit; Tindex++) {
      if (Primes[Tindex]) {
        for (int Tver = Tindex; Tindex*Tver <= Limit; Tver++) {
          Primes[Tindex*Tver] = false;
        } 
      } 
    }  
    for (int Tindex = 2; Tindex <= Limit; Tindex++) {
      if (Primes[Tindex]) {
        NumberOfPrimes++;
      } 
    } 
    System.out.println("There are " + NumberOfPrimes +
                       " prime numbers from 0 to " + Limit );
    } 
}

