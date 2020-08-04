package composition;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.logging.Logger;

public class CombineLambdas {
    public static void main(String[] args) {
        Logger log = Logger.getLogger("Logger");

        List<String> stringsWithNulls = Arrays.asList("this", null,
                "is", null, null, "a", "list", null, "with", "nulls");

        Predicate<String> nullFilter = Objects::nonNull;
        Predicate<String> evens = s -> s.length() % 2 == 0;

        Consumer<String> logger = log::info;
        Consumer<String> printer = System.out::println;

        stringsWithNulls.stream()
                .filter(nullFilter.and(evens))
                .forEach(logger.andThen(printer));
    }
}
