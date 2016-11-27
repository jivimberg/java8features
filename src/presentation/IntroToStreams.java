package presentation;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("Duplicates")
public class IntroToStreams {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //given the values, double the even numbers and total.

        int result = 0;

        for(int e : numbers) {
            if(e % 2 == 0) {
                result += e * 2;
            }
        }

        System.out.println(result);

        // Fixme: spaghetti code! you have to go back and forth to understand what's going on. Keep in the head many variables.

        // Fixme: Think of streams as a fancy iterator

        // Fixme: The for hammer. We have been using 'for' for everything

        // TODO: add the System.out only at last moment

        System.out.println(
                 numbers.stream()
                        .filter(e -> e % 2 == 0) // Fixme: explain filter
                        .map(e -> e * 2) // Fixme: explain map
                        //.reduce(0, (x, y) -> x + y));
                        .reduce(0, Integer::sum)); // Fixme explain reduce


        System.out.println(
                 numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .mapToInt(e -> e * 2)
                        .sum());


        // Fixme now each step is super clear

        // Fixme: Look at the style. One method call per line. Don't ever do the magical one liner

        // DON'T DO LONG ONE LINERS!

        // Fixme: Stream is not a data structure. You can't point to data in a stream because there's no data in a stream
        // Fixme: Stream is just an abstraction: a non-mutating pipeline -> A pipeline of transformations built from the composed functions
    }
}
