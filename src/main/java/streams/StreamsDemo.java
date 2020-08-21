package streams;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.math.BigDecimal.ONE;
import static java.util.stream.Collectors.joining;

public class StreamsDemo {
    private final List<String> strings = Arrays.asList("this", "is", "a",
            "list", "of", "strings");

    public String joinStream() {
        // return a string that joines all the elements of the strings list
        // using a single space as a delimiter
        return strings.stream()
                .collect(Collectors.joining(" "));
    }

    public String joinUpperCase() {
        // convert the strings to upper case and join them using a single space
        return strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(" "));
    }

    public int getTotalLength() {
        // map the individual strings to ints and sum them
        return strings.stream()
                .mapToInt(String::length)
                .sum();
    }

    public double sumFirstNBigDecimals(int num) {
        // use the iterate method on stream, starting from BigDecimal.ONE,
        // adding BigDecimal.ONE each time
        // use the limit method to produce only "num" values
        // use mapToDouble to convert the BigDecimal instances to doubles
        // use the sum method on DoubleStream to add them up
        return Stream.iterate(BigDecimal.ONE, bd -> bd.add(BigDecimal.ONE))
                .limit(num)
                .mapToDouble(BigDecimal::doubleValue)
                .sum();
    }

    public Double sumRandoms1(int num) {
        return Stream.generate(Math::random)
                .limit(num)
                .reduce(Double::sum).orElse(0.0);
    }

    public Double sumRandoms2(int num) {
        return Stream.generate(Math::random)
                .limit(num)
                .reduce((acc, n) -> {
                    System.out.printf("Acc=%s, n=%s%n", acc, n);
                    return acc + n;
                })
                .orElse(0.0);
    }

    public Double sumRandoms3(int num) {
        Random r = new Random();
        return r.doubles()
                .limit(num)
                .sum();
    }
}
