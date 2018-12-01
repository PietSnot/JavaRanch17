/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch17;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Piet
 */
public class KarlaCarr {

}

class Team implements Comparable<Team> {

    String teamName;
    String playerName;

    Team(String teamName, String playerName) {
        this.teamName = teamName;
        this.playerName = playerName;
    }

@Override
public int compareTo(Team t) //check this in particular 
{
//    System.out.println("In compareTo");
//    System.out.format("comparing %s to %s %n", this, t);
    if (this.teamName.length() > t.teamName.length()) {
//        System.out.format("%s is larger%n*************************%n", this);
        return 1;
    } 
    else if (this.teamName.length() < t.teamName.length()) {
//        System.out.format("%s is smaller %n************************%n", this);
        return -1;
    }
    else {
//        System.out.println("equal");
        return 0;
    }
}

    @Override
    public String toString() {
        return teamName + " | " + playerName;
    }
}

class Main5 {

    public static void main(String[] args) {
        var team = new ArrayList<Team>();
        team.add(new Team("222", "Piet"));
        team.add(new Team("33", "Kees"));
        team.add(new Team("1", "Jan"));
        
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println(team);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        Collections.sort(team);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println(team);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        
        
        Set<Team> set = new TreeSet<>();
        for (int i = 0; i < team.size(); i++) set.add(team.get(i));
        System.out.println(set);
    }
}
