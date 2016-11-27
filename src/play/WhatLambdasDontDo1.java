package play;

import java.util.Arrays;
import java.util.List;

public class WhatLambdasDontDo1 {
    public static void main(String[] args) {

        // 1) Modifying variable inside a lambda does not work

        int count = 0;
        List<String> strings = Arrays.asList("a", "b", "c");
        strings.forEach(s -> {
//            count++; // error: can't modify the value of count
        });

        //Fixme: things need to be final or effectively final (they must not be modified after they're assigned)

        // Example of effectively final
        String message = "message number: ";
        List<String> numbers = Arrays.asList("1", "2", "3");
        numbers.forEach(n -> {
            System.out.println(message + n);
        });

//        message = "Won't work!";
    }
}
