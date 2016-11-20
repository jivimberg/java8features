package presentation;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings({"ForLoopReplaceableByForEach", "Convert2Lambda", "Anonymous2MethodRef", "Convert2MethodRef", "Convert2streamapi"})
public class IteratorExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //external iterators
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        //external iterators also
        for (int e : numbers) {
            System.out.println(e);
        }

        //internal iterators
        numbers.forEach(new Consumer<Integer>() {
            public void accept(Integer value) {
                System.out.println(value);
            }
        });

        // Fixme: Now we don't control the iteration!
        // Fixme: We benefit from polymorphism: The implementation can be specially tailored for each data structure

        //internal iterators with lambda notation
        numbers.forEach((Integer value) -> System.out.println(value));

        numbers.forEach((value) -> System.out.println(value));
        //Java 8 has type inference (finally) but only for lambda expressions.

        numbers.forEach(value -> System.out.println(value));
        //parenthesis is optional, but only for one parameter lambdas.

        numbers.forEach(System.out::println);

        // Fixme: Show how Intellij will try to push you to the best style

        // PLEASE KEEP LAMBDAS SHORT!
        // Fixme: Longs lambdas are hard to read. More lines leads to duplication code.

        // Fixme: Also multiple lines implies using {}, ...; , and returns => too noisy
    }
}

