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
public class SteveDyke {

    public static void main(String... args) {
        List<String> temp = new LinkedList<String>();
        String operation = "123 567891123456789212345678931234567894  12   123456789212345678931234567894  1234567  8901 23";
        int startPos = 0;
        int maxLength = 40;
        int endPos = 0;

        while (startPos < operation.length()) {
            if (startPos + maxLength >= operation.length()) {
                temp.add(operation.substring(startPos).trim());
                break;
            }
            if (operation.charAt(startPos + maxLength) == ' ') endPos = startPos + maxLength;
            else endPos = startPos + operation.substring(startPos, startPos + maxLength).lastIndexOf(" ");
            if (endPos < startPos) endPos = startPos + maxLength;
            
            temp.add(operation.substring(startPos, endPos).trim());
            startPos = operation.charAt(endPos) == ' ' ? endPos + 1: endPos;
        }
        System.out.println(operation + ": " + operation.length() + "\n**********************");
        temp.forEach(s -> System.out.println(s + " : " + s.length()));
    }
}
