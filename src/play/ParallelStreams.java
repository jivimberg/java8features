package play;

import addicted.a06_parallel_stream.Timeit;

import java.util.Arrays;
import java.util.List;

public class ParallelStreams {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

            numbers.stream()
                    .filter(e -> e % 2 == 0)
                    .mapToInt(e -> e * 2)
                    .sum();
    }

    private static int compute(int number) {
        //assume this is time intensive
        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
        }
        return number * 2;
    }
}
