/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch17;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.ToDoubleFunction;
import static java.util.stream.Collectors.toMap;

/**
 *
 * @author Piet
 */
public class AlDavis {
    public static void main(String... args) {
        Map<Film, List<Rating>> ratings = Map.of(
            new Film("A"), List.of(Rating.Bad, Rating.Bad, Rating.Unrated),
            new Film("B"), List.of(Rating.Good, Rating.Good, Rating.Bad),
            new Film("C"), List.of(Rating.Good, Rating.Unrated, Rating.Bad)
        );
        Set<Film> set = new TreeSet<>(new FilmComparator(ratings));
        set.addAll(ratings.keySet());
        set.forEach(System.out::println);
        System.out.println("***********************");
        ratings.forEach((k, v) -> System.out.format("Film: %s, av.rating: %f %n", k, Rating.averageRating(v)));
        
        Map<Film, Double> averages = ratings.entrySet().stream()
            .collect(toMap(entry -> entry.getKey(), 
                           entry -> Rating.averageRating(entry.getValue())
                          )
            )
        ;
        averages.entrySet().forEach(System.out::println);
    }
    
    static class FilmComparator implements Comparator<Film> {
        private final Map<Film, List<Rating>> ratings;
        public FilmComparator(Map<Film, List<Rating>> ratings) {
            this.ratings = new HashMap<>();
            ratings.forEach((k, v) -> this.ratings.put(k, new ArrayList<>(v)));
        }
        @Override
        public int compare(Film f1, Film f2) {
            ToDoubleFunction<Film> f = film -> Rating.averageRating(ratings.getOrDefault(film, List.of(Rating.Unrated)));
            Comparator<Film> comp = Comparator.comparingDouble(f).reversed();
            return comp.compare(f1, f2);
        }
    }
}

class Film {
    final String title;
    public Film(String t) {
        title = t;
    }
    @Override
    public String toString() {
        return title;
    }
}
    
enum Rating {
    Bad(-2), Unrated(0), Good(3);
    final private int rating;
    
    Rating(int rating) {
        this.rating = rating;
    }
    
    public int rating() {
        return rating;
    }
    
    public static double averageRating(List<Rating> list) {
        if (list == null || list.isEmpty()) throw new IllegalArgumentException("no data available");
        return list.stream().mapToInt(Rating::rating).average().getAsDouble();
    }
}
