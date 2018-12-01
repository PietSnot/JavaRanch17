/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch17;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Piet
 */
public class SteveDyke2 {

    public static void main(String... args) {
        List<String> temp = new LinkedList<String>();
        String operation = "123456789112345678921234567893123456789  412345678951111111111111111111111111111111111111";
        if (operation.length() > 40) {

            String operationMod = operation;

            int maxLength = 40;
            int lIndex = 0;
            int counter = 0;
            while (operation.length() > 0 || counter > 10) {

                try {
                    lIndex = operation.substring(0, maxLength).lastIndexOf(" ");
                } catch (Exception e) {
                }

                if (operation.length() > 40) {
                    operationMod = operation.substring(0, Math.min(operation.length(), lIndex));

                    temp.add(operationMod);

                    operation = operation.substring(lIndex + 1);
                } else {
                    temp.add(operation);
                    break;
                }
                counter++;
            }

        } else {

            temp.add(operation);

        }
        
        temp.forEach(System.out::println);
    }
}
