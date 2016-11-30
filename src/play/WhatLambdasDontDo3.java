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

}
