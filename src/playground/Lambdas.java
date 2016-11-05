package playground;

import java.util.Arrays;
import java.util.List;

public class Lambdas {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Ananas", "Mango", "Banana", "Beer");

        //noinspection Convert2MethodRef
        fruits.forEach(fruit -> System.out.println(fruit));

        // is the same as:
        fruits.forEach(System.out::println);

        Thread t = new Thread(() -> System.out.println("hi jivi"));
        t.run();
    }
}
