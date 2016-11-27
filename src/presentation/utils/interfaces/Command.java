package presentation.utils.interfaces;

//Fixme: It's sort of like @Override in this way; it declares intention and doesn't allow you to use it incorrectly

import java.util.Collection;

@FunctionalInterface
public interface Command {

    void doAction();

    // A functional interface can only have 1 method
//    void undoAction();

    // A functional interface can have other default methods
    default void printAction(){
        System.out.println("I'm doing an action");
    }

    // Static methods are permitted
    static void doRandomCommand(Collection<Command> commands) {
        commands.stream()
                .findAny()
                .ifPresent(Command::doAction);
    }
}
