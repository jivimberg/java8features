package presentation;

import presentation.utils.TimeIt;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("EmptyCatchBlock")
public class ParallelStreams {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        TimeIt.code(() ->
                System.out.println(
                        //numbers.stream()
                        numbers.parallelStream()
                                .filter(e -> e % 2 == 0)
                                .mapToInt(ParallelStreams::compute)
                                .sum()));
    }

    private static int compute(int number) {
        //assume this is time intensive
        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
        }
        return number * 2;
    }

    // Use parallel streams when:
    //      a) The problem is parallelizable -> Like this map example
    //      b) You're willing to use lots of resources to get the answer faster -> Example of asking everybody for Nico's email address
    //      c) When data size is big enough you'll get the boost of performance
    //      d) When the task computation is intensive enough you'll gain a boost of performance
    // And ALWAYS MEASURE!
}
