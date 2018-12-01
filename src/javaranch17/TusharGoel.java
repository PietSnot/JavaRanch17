/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch17;

import java.util.Arrays;
import java.util.Collections;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;

/**
 *
 * @author Piet
 */
public class TusharGoel {

    static void rotateRight(int[] inp, int k) {
        p(inp);
        int size = inp.length;
        System.out.println("gcd = " + gcd(size, k));
        int temp = 0;
        int to = 0, from = 0;
        for (int i = 0; i < gcd(size, k); i++) {
            to = size - 1 - i;
            temp = inp[to];
            System.out.println("nieuwe i-loop; to = "+ to);
            while (true) {
//                from = (to - k) % size;
from = to - k;
if (from < 0) from += size;

                if (from == i) {
                    break;
                }
                System.out.println("making element " + from + " equal to element " + to);
                inp[to] = inp[from];
                p(inp);
                to = from;
            }
            inp[to] = temp;
            System.out.println("aan het einde van ronde 1: ");
            p(inp);
        }
        
    }
    
    private static void rotateRight2(int[] a, int p) {
        var size = a.length;
        var b = Arrays.copyOf(a, size);
        IntStream.range(0, size).forEach(i -> a[(i + p) % size] = b[i]);
    }
    
    private static int[] rotateRight3(int[] a, int p) {
        var list = Arrays.stream(a).boxed().collect(toList());
        Collections.rotate(list, p);
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int gcd(int n, int b) {
        if (b == 0) return n;
        return gcd(b, n % b);
    }
    
    public static void rotateRight4(int[] a, int k) {
        Integer[] backup = new Integer[a.length];
        Arrays.fill(backup, null);
        int size = a.length;
        while (k < 0) k += size;
        k = k % size;
        p(a);
        for (int blocknr = 0; blocknr < k; blocknr++) {
            int to = size - 1 - blocknr;
            int from = to - k;
            int temp = a[to];
            while (from >= 0) {
                System.out.println("shifting element " + from + " to " + to);
                a[to] = a[from];
                to = from;
                p(a);
                from -= k;
            }
            backup[(size - 1 - blocknr + k) % size] = temp;
        }
        for (int i = 0; i < backup.length; i++) {
            if(backup[i] != null) a[i] = backup[i];
        }
    }
    
public static void rotateRight5(int[] a, int shift) {
    int from = 0, to = 0;
    int loopnr = 0;
    int size = a.length;
    int temp = 0, stop = 0;
    p(a);
    for (loopnr = 0; loopnr < gcd(size, shift); loopnr++) {
        to = size - 1 - loopnr;
        temp = a[to];
        stop = (to + shift) % size;
        System.out.format("new loop, loopnr = %d, to = %d, temp  = %d%n", loopnr, to, temp);
        while (true) {
            from = to - shift;
            if (from < 0) from += size;
            System.out.format("moving index %d to index %d, a[from] = %d, a[to] = %d%n", from, to, a[from], a[to]);
            a[to] = a[from];
            to = from;
            if (from == stop) break;
        }
        System.out.format("end of loopnr %d, moving temp to index %d %n", temp, a[from]);
        a[from] = temp;
    }
}
    
private static void p(int[] array) {
    System.out.println("array: "+ Arrays.toString(array));
    System.out.println("*******************************");   
}

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6};
        rotateRight5(input, 5);
        System.out.println(Arrays.toString(input));
        System.out.println("**************************");
    }

}
