/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch17;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Piet
 */
public class JordiVanSelm {
    
    static Map<Character, Integer> letters = new HashMap<>();
    static Map<Point, Integer> fields = new HashMap<>();
    
    public static void main(String... args) {
        
        letters.put('x', 4);
        letters.put('y', 5);
        
        fields.put(new Point(1, 0), 3);
        fields.put(new Point(3, 0), 4);
        
        int[][] board = new int[10][10];
        
        String word = "abxy";
        
        int value = putWord(word, new Point(0, 0), new Point(1, 0));
        System.out.format("value of the word %s is: %d %n", word, value);    
    }
    
    private static int putWord(String s, Point location, Point direction) {
        int result = 0;
        for (char c: s.toCharArray()) {
            int value = letters.getOrDefault(c, 1);
            int boardvalue = fields.getOrDefault(location, 1);
            result += value * boardvalue;
            location.move(direction.x, direction.y);
        }
        return result;
    }
}
