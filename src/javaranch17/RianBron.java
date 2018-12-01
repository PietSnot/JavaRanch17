/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch17;

import java.awt.geom.Point2D;

/**
 *
 * @author Piet
 */
public class RianBron {
    public static void main(String... args) {
        Point2D P = new Point2D.Double(1, 1);
        double length = P.distance(new Point2D.Double());
        double sinus = P.getY() / length;   // so, NO Math.sin(x / y)!
        double angleInRadians = Math.asin(sinus);
        double angleInDegrees = Math.toDegrees(angleInRadians);
        System.out.println("point given = " + P);
        System.out.println("length = " + length);
        System.out.println("sinus = " + sinus);
        System.out.println("angleInRadians = " + angleInRadians);
        System.out.println("angle in degrees = " + angleInDegrees);
    }
}
