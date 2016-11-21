package presentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@SuppressWarnings("Duplicates")
public class AvoidSharedMutability {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);

    //double the even values and put that into a list.
    
    //wrong way to do this.
    List<Integer> doubleOfEven = new ArrayList<>();

    numbers.stream()
           .filter(e -> e % 2 == 0)
           .map(e -> e * 2)
           .forEach(doubleOfEven::add);
    //mutability is OK, sharing is nice, shared mutability is devils work

    // Fixme: Avoid shared mutability!! Don't change data while using a stream
    
    System.out.println(doubleOfEven); //Don't do this.

    // To do this we use a collector!
    List<Integer> doubleOfEven2 =
      numbers.stream()
             .filter(e -> e % 2 == 0)
             .map(e -> e * 2)
             .collect(toList());
    System.out.println(doubleOfEven2);
  }
}