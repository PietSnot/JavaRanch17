/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch17;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 *
 * @author Piet
 */
public class FilipTelente extends MyTask {
    private Integer[] elements;
    private int a;
    private int b;
    
    public FilipTelente(Integer[] elements, int a, int b) {
        this.elements = elements;
        this.a = a;
        this.b = b;
    }
    
    public Integer compute() {
        if ((b - a) < 2) return Math.min(elements[a], elements[b]);
        else {
            int m = a + (b - a) / 2;
            System.out.println(a + "," + m + "," + b);
            MyTask t1 = new FilipTelente(elements, a, m);
            int result = t1.fork().join();
            return Math.min(new FilipTelente(elements, m, b).compute(), result);
        }
    }
    
    public static void main(String... args) throws InterruptedException, ExecutionException {
        Integer[] elements = new Integer[]{0, -3, 2, -54};
        MyTask task = new FilipTelente(elements, 0, elements.length - 1);
        ForkJoinPool pool = new ForkJoinPool(1);
        Integer sum = pool.invoke(task);
        System.out.println("Min = " + sum);
    }
}

abstract class MyTask extends ForkJoinTask<Integer> {
    @Override
    public boolean exec() {
        return true;
    }
    @Override
    public void setRawResult(Integer v) {
    }
    @Override
    public Integer getRawResult() {
        // what to return here?  If I return 3, then the FindMin 
        // will not return the correct answer
        return 3;
    }
}



