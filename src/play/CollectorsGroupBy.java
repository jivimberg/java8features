package play;

import addicted.a11_toMap.Gender;
import addicted.a11_toMap.Person;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;

public class CollectorsGroupBy {
  public static void main(String[] args) {
    List<Person> people = createPeople();

    //given a list of people, create a map where
    //their name is the key and value is all the people with that name.


  }

  private static List<Person> createPeople() {
    return Arrays.asList(
            new Person("Sara", Gender.FEMALE, 20),
            new Person("Sara", Gender.FEMALE, 22),
            new Person("Bob", Gender.MALE, 20),
            new Person("Paula", Gender.FEMALE, 32),
            new Person("Paul", Gender.MALE, 32),
            new Person("Jack", Gender.MALE, 2),
            new Person("Jack", Gender.MALE, 72),
            new Person("Jill", Gender.FEMALE, 12)
    );
  }
}