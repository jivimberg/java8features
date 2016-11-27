package presentation;

import presentation.utils.interfaces.Bird;
import presentation.utils.interfaces.Eagle;
import presentation.utils.interfaces.Penguin;

import java.util.Arrays;

public class InterfacesImprovements {

    public static void main(String[] args) {
        // Fixme: A common scenario in Java libraries is, for some interface Foo, there would be a companion utility class
        // Fixme: Foos with static methods for generating or working with Foo instances.
        // Fixme: Now that static methods can exist on interfaces, in many cases the Foos utility class can go away
        // Fixme: (or be made package-private), with its public methods going on the interface instead.

        Bird anEagle = new Eagle();
        Bird anotherEagle = new Eagle();
        Bird aPenguin = new Penguin();

        System.out.println(Bird.ofAFeather(Arrays.asList(anEagle, anotherEagle, aPenguin)));
    }
}
