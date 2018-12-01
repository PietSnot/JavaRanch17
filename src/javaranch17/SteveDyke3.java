/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Piet
 */
public class SteveDyke3 {

    public static void main(String... args) {
        var input = "0123456789112345678921234567893122456789   01234567891   abcdefghijkl mnopqrstuvwxyz1234567 890*******************************************";
        var maxLength = 20;
        splitStringOnSpace(input, maxLength).forEach(s -> System.out.format("%s: length = %d%n", s, s.length())); 
    }
    
    private static IntStream breakpoints(String s, int maxLength) {
        var result = IntStream
            .iterate(0, p -> p < s.length(), p -> nextBreakpoint(s, p, maxLength))
            .skip(1)
        ;
        return IntStream.concat(result, IntStream.of(s.length()));
    }
    
    public static List<String> splitStringOnSpace(String s, int maxLength) {
        var temp = s.trim().replaceAll("\\s+", " ");
        int[] a = {0};
        return breakpoints(temp, maxLength)
            .mapToObj(p -> {var t = temp.substring(a[0], p).trim(); a[0] = p; return t;})
            .collect(toList())
        ;
    }
    
    private static int nextBreakpoint(String s, int startposition, int maxLength) {
        // algo:
        // if remaining length of s, counted from p, is at most maxLength, return s.length()
        // if char at position startposition + maxLength is a space, return startposition + maxLength + 1
        // let int x = last index of a space
        // if x == -1 (i.e. no space present) then return startposition + maxLength
        // else return startposition + x + 1
        int endposition = startposition + maxLength;
        if (endposition >= s.length()) return s.length();
        if (s.charAt(endposition) == ' ') return endposition + 1;
        int x = s.substring(startposition, endposition).lastIndexOf(' ');
        return x == -1 ? endposition : startposition + x + 1;
    }
}