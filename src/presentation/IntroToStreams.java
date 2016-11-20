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

        System.out.println(
                 numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .map(e -> e * 2)
                        .reduce(0, Integer::sum));

        System.out.println(
                 numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .mapToInt(e -> e * 2)
                        .sum());


        // Fixme now each step is super clear

        // Fixme: Look at the style. One method call per line. Don't ever do the magical one liner

        // DON'T DO LONG ONE LINERS!
    }
}
