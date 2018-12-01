/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch17;

/**
 *
 * @author Piet
 */
public class JimGallagher {

}

class Matrix {

    private double[][] data;
    private int rows;
    private int columns;

    public static void main(String... args) {
        var data = new double[][]{{0.5, 1, 0}, {1, 0.5, 0}, {0, 0.5, 1.25}, {0.5, 0.5, 0.75}};
        var m3 = new Matrix(data);
        System.out.println("Matrix m3 is a:");
        System.out.println(m3.toString(m3.data));
//        Matrix m3b = new Matrix(data.clone());
        var b = '4';
        var c = '5';
        System.out.println(Integer.parseInt("" + b + c));
    }

    public Matrix(double[][] data, int rows, int columns) {
//        this.data = new double[rows][columns];
        this.data = data;
        this.rows = rows;
        this.columns = columns;
    }

    public Matrix(double[][] data) {
//        this.data = new double[rows][columns];
          this.data = data;
    }

    public String toString(double[][] data) {
        var sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                sb.append(" "); sb.append(data[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
