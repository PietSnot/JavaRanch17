/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch17;

import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Piet
 */
public class PhillipSmall {
    public static void main(String... args) {
        List<Integer> originals = List.of(5, 5, 10, 15);
        List<Integer> positions = List.of(0, 3);
        if (!listOfPositionsIsOkay(originals, positions))
            throw new RuntimeException("positions list is not okay!")
        ;
        System.out.println("partial sum is " + positions.stream().mapToInt(originals::get).sum());
    }
    private static boolean listOfPositionsIsOkay(List<Integer> original, List<Integer> positions) {
        return positions.stream().allMatch(i -> i < original.size());
    }
}
