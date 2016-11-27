package presentation.utils.interfaces;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public interface Bird {

    String getFeather();

    default void fly() {
        System.out.println("I'm flying!!");
    }

    static Map<String, List<Bird>> ofAFeather(Collection<Bird> birds) {
        return birds.stream()
                    .collect(groupingBy(Bird::getFeather));
    }
}
