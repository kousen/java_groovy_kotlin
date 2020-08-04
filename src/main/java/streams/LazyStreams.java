package streams;

import java.util.stream.IntStream;

public class LazyStreams {

    private int multByTwo(int n) {
        System.out.printf("Inside multByTwo with arg %d%n", n);
        return n * 2;
    }

    private boolean divByThree(int n) {
        System.out.printf("Inside divByThree with arg %d%n", n);
        return n % 3 == 0;
    }


    public int firstEvenDivBy3() {
        return IntStream.range(100, 200)
                .filter(x -> x % 3 == 0)
                .map(x -> x * 2)
                .findFirst().orElse(0);
    }

    public int firstEvenDivBy3Verbose() {
        return IntStream.range(100, 200)
                .filter(this::divByThree)
                .map(this::multByTwo)
                .findFirst().orElse(0);
    }
}
