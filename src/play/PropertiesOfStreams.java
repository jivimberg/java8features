package play;

import java.util.Arrays;
import java.util.List;

public class PropertiesOfStreams {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);

    //Streams can be:

    numbers.stream()
           .filter(e -> e % 2 == 0)
           .forEach(System.out::println);
    //sized, ordered, non-distinct, non-sorted


  }
}