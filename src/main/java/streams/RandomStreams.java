package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomStreams {
    public static final int LIMIT = 10;

    public static void main(String[] args) {
        Random r = new Random();
        r.ints()
         .limit(LIMIT)
         .sorted()
         .forEach(System.out::println);

        r.doubles()
         .limit(LIMIT)
         .filter(x -> x < 0.5)
         .sorted()
         .forEach(System.out::println);

        List<String> longs = r.longs()
                              .limit(LIMIT)
                              .mapToObj(Long::toString)
                              .toList();
        System.out.println(longs);

        List<Integer> listOfInts = r.ints()
                                    .limit(LIMIT)
                                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(listOfInts);
    }
}
