package play;

import java.io.IOException;

public class WhatLambdasDontDo2 {
    // 2) Exception transparency

    void appendAll(Iterable<String> values, Appendable out)
            throws IOException { // doesn't help with the error
        values.forEach(s -> {
//            out.append(s); // error: can't throw IOException here
            // Consumer.accept(T) doesn't allow it
        });
    }

}
