package playground;

import java.util.stream.Stream;

public class Lambdas {
    public static void main(String[] args) {
        Stream.iterate(0, e -> e - 1);
    }
}
