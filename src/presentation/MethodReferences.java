package presentation;

import java.util.Arrays;
import java.util.List;

// Todo: Flor -> see if you can rewrite this examples using Chronometer so you don't spoil streams

@SuppressWarnings({"ForLoopReplaceableByForEach", "Convert2Lambda", "Anonymous2MethodRef", "Convert2MethodRef", "Convert2streamapi"})
public class MethodReferences {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.forEach(System.out::println); // What kind of method is System.out.println() ??
        // It's a instance method. Out is an instance of System

        numbers.stream()
//                .map(e -> String.valueOf(e))
                .map(String::valueOf)
                .forEach(System.out::println);

        // Fixme: This looks a lot like line 12 but it's actually a static method reference.
        // Fixme: In both cases the parameter is used as an argument to the specified function

        numbers.stream()
                .map(e -> String.valueOf(e))
                // .map(e -> e.toString())
                .map(String::toString)
                .forEach(System.out::println);

        // Fixme: toString() is a method of the parameter
        // Fixme: now we are calling a function on the parameter instead


        numbers.stream()
              // .reduce(0, (total, e) -> Integer.sum(total, e)));
              .reduce(0, Integer::sum);

        // Fixme: Order makes a difference here!

        numbers.stream()
                .map(String::valueOf)
                // .reduce("", (carry, str) -> carry.concat(str)));
                .reduce("", String::concat);

        // Now one parameter is the target, the other is the argument!

        // Fixme: Limitations:
        // Fixme:   1) you can't modify the data
        // Fixme:   2) There can't be collision between instance and static method. It confuses the compiler
    }
}
