package presentation;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("Duplicates")
public class Performance {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
    
    //given an ordered list find the double of the first even number greater than 3.
    
    int result = 0;
    for(int e : numbers) {
      if(e > 3 && e % 2 == 0) {
        result = e * 2;
        break;
      }
    }
    System.out.println(result);
    // Fixme: This code has a bug! It may return 0 when it doesn't found anything. The stream version returns Optional[8]

    // Fixme: Optional by Java, no more Guava needed

    //how much work? 8 units work

    System.out.println(
      numbers.stream()
             .filter(Performance::isGT3)
             .filter(Performance::isEven)
             .map(Performance::doubleIt)
             .findFirst());

    // Fixme: Stream are super lazy

    // Fixme: Intermediate operations are postpone until a final evaluation is called (like findFirst). If findFirst() is not called nothing happens
    // Fixme: Operations are applied for 1 element at a time, and not the entire collection. So in reality the time is = to imperative style coding.
  }

  private static boolean isGT3(int number) {
    System.out.println("isGT3 " + number);
    return number > 3;
  }

  private static boolean isEven(int number) {
    System.out.println("isEven " + number);
    return number % 2 == 0;
  }

  private static int doubleIt(int number) {
    System.out.println("doubleIt " + number);
    return number * 2;
  }
}