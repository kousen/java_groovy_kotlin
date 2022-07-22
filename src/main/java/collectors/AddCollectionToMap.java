package collectors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddCollectionToMap {

    private static <K, V> void printMap(Map<K, V> map) {
        map.forEach((k, v) -> System.out.printf("%s: %s%n", k, v));
    }

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book(1, "Java 8 in Action"),
                new Book(2, "Java SE8 for the Really Impatient"),
                new Book(3, "Core Java Volume I -- Fundamentals"),
                new Book(4, "Functional Programming in Java"),
                new Book(5, "Making Java Groovy"),
                new Book(6, "Head First Java"),
                new Book(7, "Effective Java"),
                new Book(8, "Java 8 Pocket Guide"),
                new Book(9, "Gradle Recipes for Android"),
                new Book(10, "Spring Boot in Action")
        );

        // Option 1: explicit identity lambda
        Map<Integer, Book> bookMap = books.stream()
                .collect(Collectors.toMap(Book::id, b -> b));

        printMap(bookMap);

        // Option 2: Function.identity method
        bookMap = books.stream()
                .collect(Collectors.toMap(Book::id, Function.identity()));

        printMap(bookMap);

        // Option 3: reduce(U identity,
        //                  BiFunction<U,? super T,U> accumulator,
        //                  BinaryOperator<U> combiner)
        bookMap = books.stream()
                .reduce(new HashMap<>(),  // init accumulator with map
                        (map, book) -> {               // add a book to the map
                            map.put(book.id(), book);
                            return map;
                        },
                        (m1, m2) -> {                  // combine maps
                            m1.putAll(m2);
                            return m1;
                        });

        printMap(bookMap);
    }
}
