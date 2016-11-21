package presentation;

import java.util.Arrays;
import java.util.List;

public class StreamCommonOperations {

  // Fixme: Stream is not a data structure. You can't point to data in a stream because there's no data in a stream
  // Fixme: Stream is just an abstraction: a non-mutating pipeline -> A pipeline of transformations built from the composed functions

  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    // We've seen this already
    System.out.println(
      numbers.stream()
             .filter(e -> e % 2 == 0)
             .mapToDouble(e -> e * 2.0)
             .sum());

    // Fixme: Filter and map same swimlane, reduce across swimlanes. Reduce transforms from collection to single value


    //filter: 0 <= number of elements in the output <= number of input
    //parameter: Stream<T> filter takes Predicate<T>
    
    //map transforms values
    // number of output == number of input
    //no guarantee on the type of the output with respect to the type of the input
    //parameter:  Stream<T> map takes Function<T, R> to return Stream<R>
   
   
 //both filter and map stay within their swimlanes
 
 //reduce cuts across the swimlanes
 
 //reduce on Stream<T> takes two parameters:
 //first parameter is of type T
 //second parameter is of type BiFunction<R, T, R> to produce a result of R
 /*
        filter      map           reduce
                                  0.0
                                   \
 x1       |                         \
---------------------------          \
 x2       ->          x2'     ->      +
---------------------------            \
 x3       |                             \
---------------------------              \
 x4       ->          x4'      ->         +
---------------------------                \
                                            \




      1            2             3           4
      |           |              |           |
1 -> *  -> 1 ->   *  -> 2   ->   *  -> 6  -> * -> 24   


 */
  }
}