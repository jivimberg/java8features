package presentation;

import presentation.utils.interfaces.Bird;
import presentation.utils.interfaces.Command;
import presentation.utils.interfaces.Eagle;
import presentation.utils.interfaces.Penguin;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class InterfacesImprovements {

    public static void main(String[] args) {
        // Fixme: A common scenario in Java libraries is, for some interface Foo, there would be a companion utility class
        // Fixme: Foos with static methods for generating or working with Foo instances.
        // Fixme: Now that static methods can exist on interfaces, in many cases the Foos utility class can go away
        // Fixme: (or be made package-private), with its public methods going on the interface instead.

        Bird anEagle = new Eagle();
        Bird anotherEagle = new Eagle();
        Bird aPenguin = new Penguin();

        List<Bird> birdList = Arrays.asList(anEagle, anotherEagle, aPenguin);
        System.out.println(Bird.ofAFeather(birdList));

        // TODO show @FunctionalInterface

        // Include this example?
        InterfacesImprovements.applyCommand(birdList, () -> System.out.println("saw a bird"));
    }

    private static void applyCommand(Collection<Bird> birds, Command command) {
        birds.forEach(e -> command.doAction());
    }
}
