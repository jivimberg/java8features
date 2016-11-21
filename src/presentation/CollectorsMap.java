package presentation;

import addicted.a11_toMap.Gender;
import addicted.a11_toMap.Person;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toMap;

public class CollectorsMap {
  public static void main(String[] args) {
    //create a Map with name and age as key, and the person as value.

    List<Person> people = createPeople();

    System.out.println(
            people.stream()
                    .collect(toMap(
                            person -> person.getName() + "-" + person.getAge(), // function for the key
                            person -> person))); // function for the value

  }

  // TODO add this bit later
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