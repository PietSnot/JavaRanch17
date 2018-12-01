/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 *
 * @author Piet
 */
public class MuraliJackson {

}

class Favorite implements Comparable<Favorite> {

    private String State;
    private String bondName;
    private String favorite;
    private static Comparator<Favorite> comparator;
    
    static {
        Comparator<Favorite> comparatorAll = (a, b) -> {
            var aContainsAll = a.State.contains("All");
            var bContainsAll = b.State.contains("All");
            return aContainsAll && !bContainsAll ? -1 :
                   !aContainsAll && bContainsAll ?  1 :
                                                    0 ;
        };
        var comparatorRest = Comparator.comparing(Favorite::getBondName).thenComparing(Favorite::getFavorite);
        comparator = comparatorAll.thenComparing(comparatorRest);
    }

    @Override
    public String toString() {
        return this.State + "---" + this.bondName + "---" + this.favorite;
    }

    public Favorite(String state, String bondName, String favorite) {
        super();
        State = state;
        this.bondName = bondName;
        this.favorite = favorite;
    }

    public Favorite() {

    }
    
    public String getBondName() {
        return bondName;
    }
    
    public String getFavorite() {
        return favorite;
    }
    
    @Override
    public int compareTo(Favorite other) {
        return comparator.compare(this, other);
    }
    
    public static Comparator<Favorite> getComparator() {
        return comparator;
    }
    
    public static Comparator<Favorite> getComparatorReversed() {
        return comparator.reversed();
    }

}

class App {

    public static void main(String[] args) {
        var obj1 = new Favorite("All", "Airlines", "unfav");
        var obj2 = new Favorite("All", "Change", "unFav");
        var obj3 = new Favorite("All", "Rider", "fav");
        var obj4 = new Favorite("All", "Change", "fav");
        var obj5 = new Favorite("AV", "AK Invest", "unfav");
        var obj6 = new Favorite("AV", "Changert", "fav");
        var obj7 = new Favorite("AV", "AK Transmitter", "unfav");
        var obj8 = new Favorite("DF", "DC Spa", "fav");
        var obj9 = new Favorite("DF", "DC Service", "unfav");
        var obj10 = new Favorite("WD", "StateForms", "fav");

        HashMap IBLForms = new HashMap();

        ArrayList FormsList = new ArrayList();
        FormsList.add(obj1);
        FormsList.add(obj10);
        FormsList.add(obj3);
        FormsList.add(obj7);
        FormsList.add(obj5);
        FormsList.add(obj2);
        FormsList.add(obj4);
        FormsList.add(obj6);
        FormsList.add(obj8);
        FormsList.add(obj9);
        
        FormsList.forEach(System.out::println);
        System.out.println("***************************");

        FormsList.sort(Favorite.getComparator());
        FormsList.forEach(System.out::println);
        System.out.println("***************************");
        
        FormsList.sort(Favorite.getComparatorReversed());
        FormsList.forEach(System.out::println);
    }

}
