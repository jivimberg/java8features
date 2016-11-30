package play;

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

  }
}