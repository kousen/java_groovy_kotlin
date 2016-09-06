package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapFilterReduce {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("this", "is", "a",
                "list", "of", "strings");

        List<Integer> ints = strings.stream()
                .mapToInt(String::length)
                .filter(n -> n % 2 == 0)
                .boxed()
                .collect(Collectors.toList());


    }
}
