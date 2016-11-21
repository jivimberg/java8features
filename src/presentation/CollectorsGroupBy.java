package presentation;

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

    // Fixme: Talk about how you would do this in imperative form: Create map, ask each item the name, see if the list is created etc.
    // Fixme: How many lines? More important: who founds it fun to write that code??

    System.out.println(
            people.stream()
                    .collect(groupingBy(Person::getName)));
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