package streams;

import java.util.List;

public class SumNumbers {
    public static int getTotal(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 3 == 0)
                .map(n -> n * 2)
                // .reduce(0, (acc, val) -> acc + val);
                .reduce(0, Integer::sum);
    }
}
