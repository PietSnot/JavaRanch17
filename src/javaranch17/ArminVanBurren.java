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
public class ArminVanBurren {
    
}

class LambdaExample {
    public static void main(String[] args) {
        new Say() {
            @Override
            public void say() {
                new Hello().hello();
            }
        }.say();
        Say say = () -> new Hello().hello();
        say.say();
        useles(() -> System.out.println("Hoi - useless"));
    }
    
    private static void useles(Say say) {
        say.say();
    }
}
 
interface Say {
    void say();
}
 
class Hello {
    void hello() {
        System.out.println("Hello");
    }
}
