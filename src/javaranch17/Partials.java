/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch17;

import java.util.Collections;
import static java.util.Collections.frequency;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Piet
 */
public class Partials {
    
    public static void main(String... args) {
        var list = List.of(1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(list);
        System.out.println(partialSomething(list, (a, b) -> a + b));
        System.out.println(partialSomething2(list, (a, b) -> a + b));

        System.out.println("***********************");
        Map<Integer, Double> map = new TreeMap<>();
        IntStream.rangeClosed(1, 6).forEach(i -> map.put(i, 1.0 / 6));
        System.out.println(map);
        System.out.println(anotherAttempt(list));
    }

    public static <T extends Number> List<T> partialSomething(List<T> list, BinaryOperator<T> f) {
        var iterator = list.iterator();
        return Stream
            .iterate(iterator.next(), p -> f.apply(p, iterator.next()))
            .limit(list.size())
            .collect(toList());
    }

    public static <T extends Number> List<T> partialSomething2(List<T> list, BinaryOperator<T> f) {
          var iterator = list.iterator();
          var result = Stream
            .iterate(iterator.next(),
                     p -> iterator.hasNext() ? f.apply(p, iterator.next()) : null
             )
            .takeWhile(Objects::nonNull)
            .collect(toList());
        return result;
    }

    public static <T extends Number> TreeMap<Double, T> cdf2(Map<T, Double> map) {
        var temp = new TreeMap<>(map);
        var result = new TreeMap<Double, T>();
        double[] sum = {0};
        temp.forEach((k, v) -> {sum[0] += v; result.put(sum[0], k);});
        return result;
    }

public static <T extends Number> TreeMap<Double, T> cdf(List<T> observations) {
    var temp = observations.stream()
        .collect(
             collectingAndThen(
                groupingBy(t -> t, TreeMap::new, counting()),
                Partials::convert
            )
        );
    return cdf2(temp);
}

static <T> TreeMap<T, Double> convert(TreeMap<T, Long> map) {
    var size = map.values().size();
    TreeMap<T, Double> result = new TreeMap<>();
    map.forEach((k, v) -> result.put(k, (double) v / size));
    return result;
}

public static <T> TreeMap<T, Double> anotherAttempt(List<T> observations) {
    var size = observations.size();
    return observations.stream().collect(
        toMap(k -> k, 
              k -> (double) frequency(observations, k) / size, 
              (a, b) -> a,   // doesn't matter
              TreeMap::new
             )
    );
}
}
