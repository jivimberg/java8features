package presentation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PropertiesOfStreams {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);

    //Streams can be:
    //  a) sized (vs boundless)
    //  b) ordered (a list is ordered a set is not)
    //  c) distinct (vs non-distinct)
    //  d) sorted (values are sorted)

    numbers.stream()
           .filter(e -> e % 2 == 0)
           .forEach(System.out::println);
    //sized, ordered, non-distinct, non-sorted

    numbers.stream()
            .filter(e -> e % 2 == 0)
            .distinct()
            .sorted()
            .forEach(System.out::println);
    //sized, ordered, distinct, sorted

    // infinite streams!
    Stream<Integer> infiniteStream = Stream.iterate(100, e -> e + 1);
    System.out.println(infiniteStream); //100, 101, 102

    //TODO Think of a cool example for infinite streams
  }
}