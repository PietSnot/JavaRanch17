/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch17;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 *
 * @author Piet
 */
public class VaibhavGargs2 {
    
    private Map<String, Integer> results = new ConcurrentSkipListMap<>();
    private Map<String, Future<Integer>> futures = new ConcurrentSkipListMap<>();
    Set<String> names = new ConcurrentSkipListSet<>();
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private PropertyChangeListener pclTaskFinished, pclNumberOfTasks;
    private ExecutorService executor = Executors.newFixedThreadPool(4);
    int numberOfTasks = 30;
    Random random = new Random();
    
    public static void main(String... args) throws InterruptedException {
        new VaibhavGargs2().go();
    }
    
    private void go() throws InterruptedException {
  
        pclTaskFinished = event -> {
            String name = event.getPropertyName();
            decreaseTasksRemaining(name);
        };
        
        pclNumberOfTasks = event -> {
            if (names.isEmpty()) allTasksCompleted();
        };
        
        pcs.addPropertyChangeListener(pclNumberOfTasks);
        
        List<String> toBeRemoved = new ArrayList<>(names);
        IntStream.range(0, numberOfTasks)
            .forEach(i -> 
                {String name = "worker " + (i < 10 ? "0" : "") + i; 
                 var s = new Vaibhav(name, results, pclTaskFinished); 
                 Future<Integer> f = executor.submit(s);
                 futures.put(name, f);
                 names.add(name);
                }
            )
        ;
        
        System.out.println("started: " + names.size() + " tasks");
    }
    
    private synchronized void decreaseTasksRemaining(String name) {
        System.out.println("decreasing numberOfTasks because " + name + " just finished");
        System.out.println("result: " + results.get(name));
        names.remove(name);
        System.out.println("*************************");
        System.out.println("tasks remaining: " + names.size());
        System.out.println("*************************");
        if (names.isEmpty()) pcs.firePropertyChange(" ", 0, 1);
    }
    
    private void allTasksCompleted() {
        System.out.println("Finished all tasks");
        System.out.println("size of results: " + results.size());
        results.entrySet().forEach(System.out::println);
        executor.shutdown();
        System.exit(0);
        
    }
    
    private static class Vaibhav implements Callable<Integer> {

        Random r = new Random();
        String name;
        Map<String, Integer> results;
        int result;
        PropertyChangeSupport pcs = new PropertyChangeSupport(this);

        private Vaibhav(String name, Map<String, Integer> results, PropertyChangeListener pcl) {
            this.name = name;
            this.results = results;
            pcs.addPropertyChangeListener(pcl);
        }

        @Override
        public Integer call() {
            result = r.nextInt(100);
            System.out.println("started " + name);
            try {
                if (r.nextDouble() < .2) {
                    Thread.currentThread().interrupt();
                    System.out.println("Interrupted thread " + name);
                }
                TimeUnit.SECONDS.sleep(r.nextInt(1) + 1);
            }
            catch (InterruptedException e) {
                result = Integer.MIN_VALUE;
            }
            results.put(name, result);
            pcs.firePropertyChange(name, -1, result);
            return result;
        }
    }
}