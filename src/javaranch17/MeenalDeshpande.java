/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch17;

import javax.swing.JOptionPane;

/**
 *
 * @author Piet
 */
public class MeenalDeshpande {

}

class Items {
// * A String instance variable to hold the item name 

    private String itemName;
// * A double instance variable to hold the price 
    private double itemPrice;
// * A constructor that takes a String and double to initialize the instance variables 
// public Items () 
// { 
// //used for sorting 
// } 

    public Items(String itemName, double itemPrice) {
        this.itemPrice = itemPrice;
        this.itemName = itemName;
    }
// * A get and set method for each instance variable 

    public String getName() {
        return itemName;
    }

    public double getPrice() {
        return itemPrice;
    }

    public void setItemName(String someItem) {
        itemName = someItem;
    }

    public void setItemPrice(double somePrice) {
        itemPrice = somePrice;
    }

    public String toString() {
        return "Item: " + itemName + " price:" + itemPrice;
    }
}

// Once you have this class created, you write a second class named CoffeeDriver.   This class has the following methods: 
class CoffeeDriver {
// sortName – this method sorts the array of items by item name and then displays the name and price of all items on the screen 

    public static void sortName(Items arr[]) {
// sorts array by name and displays the items and prices 
        int x;
        Items temp;
        for (x = 0; x < arr.length; x++) {
            if (arr[x].getName().compareTo(arr[x + 1].getName()) > 0) {
                temp = arr[x];
                arr[x] = arr[x + 1];
                arr[x + 1] = temp;
            }

            JOptionPane.showMessageDialog(null, (arr[x]));
        }
    }

// sortPrice – this method sorts the array of items by item price and then displays the name and price of all items on the screen 
    public static void sortPrice(Items arr[]) {
//  sorts the array by price and displays the list 
        int x;
        Items temp;
        for (x = 0; x < arr.length; x++) {
            if (arr[x].getPrice() > arr[x + 1].getPrice()) {
                temp = arr[x];
                arr[x] = arr[x + 1];
                arr[x + 1] = temp;
            }
            JOptionPane.showMessageDialog(null, arr[x]);

        }

    }
// main - It creates an array of Item objects using the data above to set each Item's information. 

    public static void main(String[] args) {
        String userSorted;
        int x;

        Items arr[] = new Items[5];
        arr[0] = new Items("Coffee", 1.00);
        arr[1] = new Items("Water", 2.00);
        arr[2] = new Items("Milk", 1.50);
        arr[3] = new Items("Bagel", 1.25);
        arr[4] = new Items("Donut", 0.75);
        int selectSort;
        JOptionPane.showMessageDialog(null, "Welcome to The Coffee Shop!");
        userSorted = JOptionPane.showInputDialog(null, "Please indicate how you would like to sort the menu. To sort by price, press 1. To sort by name, press 2. To exit the program, press 3.");
        selectSort = Integer.parseInt(userSorted);
// insert do while loop here 

        if (selectSort == 1);
        sortPrice(arr);

        if (selectSort == 2);
        sortName(arr);
        if (selectSort == 3);
        JOptionPane.showMessageDialog(null, "Thank you for using Wings Coffee Shop. Have a great day!");
        System.exit(0);

    }
}
