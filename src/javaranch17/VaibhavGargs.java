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
public class VaibhavGargs {
    private static class Z {
        public void test(A a) {
            a.test();
        }
        public void test(B b) {
            b.test();
        }
    }
    
    public static void main(String... args) {
        Z z = new Z();
        A a = () -> System.out.println("testing A a in class Z");
        B b = () -> {System.out.println("testong B b in class Z"); return 3;};
        z.test(a);
        z.test(b);
        z.test(() -> System.out.println("testing A a in class Z"));
        z.test(() -> {System.out.println("testong B b in class Z"); return 3;});
    }
}

interface A {
    public void test();
}
 
interface B {
    public int test();
}

//interface C extends A, B {
//    
//}