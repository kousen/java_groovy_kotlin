package functional

import java.util.stream.IntStream

class LazyStreamsGroovy {
    int firstEvenDivBy3() {
        (100..200).collect { it * 2 }
            .find { it % 3 == 0 }
    }

    int firstEvenDivBy3Verbose() {
        (100..200).collect { println it; it * 2 }
            .find { println it; it % 3 == 0 }
    }

    int firstEvenDivBy3UsingStreams() {
        IntStream.rangeClosed(100, 200)
            .map { println it; it * 2 }
            .filter { println it; it % 3 == 0 }
            .findFirst().orElse(0)
    }
}
