package play;

import java.util.stream.StreamSupport;

public class WhatLambdasDontDo3 {

    private final String secret = "foo";

    // Control flow (break, early return)
    boolean containsSecret(Iterable<String> values) {
        values.forEach(s -> {
            if (secret.equals(s)) {
//                ??? // want to end the loop and return true, but can't
//                return true; // this only returns from the lambda, not from the enclosing method. It's like a continue!
            }
        });
        return false;
    }

    // there's a better way of doing it!
    boolean containsSecretWithStreams(Iterable<String> values) {
        return StreamSupport.stream(values.spliterator(), false)
                            .anyMatch(secret::equals);
    }

    // Fixme: For what it's worth, a Spliterator is a way of operating over the elements of a collection in a way
    // Fixme: that it's easy to split off part of the collection, e.g. because you're parallelizing and want one thread
    // Fixme: to work on one part of the collection, one thread to work on another part, etc.



}
