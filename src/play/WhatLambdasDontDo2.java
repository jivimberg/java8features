package play;

import java.io.IOException;

public class WhatLambdasDontDo2 {
    // 2) Exception transparency

    // Fixme: If a checked exception may be thrown from inside a lambda, the functional interface must also declare
    // Fixme: that checked exception can be thrown. The exception is not propagated to the containing method.

    void appendAll(Iterable<String> values, Appendable out)
            throws IOException { // doesn't help with the error
        values.forEach(s -> {
//            out.append(s); // error: can't throw IOException here
            // Consumer.accept(T) doesn't allow it
        });
    }

}
