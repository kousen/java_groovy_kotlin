package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;

public class MapFilterReduce {
    public static final IntPredicate EVENS = n -> n % 2 == 0;
    public static final IntPredicate ODDS = n -> n % 2 != 0;

    private List<String> strings = Arrays.asList("this", "is", "a",
            "list", "of", "strings");

    public int sumAllLengths() {
        return strings.stream()
                .mapToInt(String::length)
                .sum();
    }

    public int sumEvenLengthStrings() {
        return strings.stream()
                .mapToInt(String::length)
                .filter(n -> n % 2 == 0)
                .sum();
    }

    public int sumOddLengthStrings() {
        return strings.stream()
                .mapToInt(String::length)
                .filter(n -> n % 2 != 0)
                .sum();
    }

    public int sumStrings(IntPredicate predicate) {
        return strings.stream()
                .mapToInt(String::length)
                .filter(predicate)
                .sum();
    }
}