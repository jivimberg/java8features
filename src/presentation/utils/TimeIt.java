package presentation.utils;

import com.sun.istack.internal.NotNull;

public class TimeIt {
    public static void code(@NotNull Runnable block) {
        long start = System.nanoTime();
        try {
            block.run();
        } finally {
            long end = System.nanoTime();
            System.out.println("Time taken(s): " + (end - start) / 1.0e9);
        }
    }
}
