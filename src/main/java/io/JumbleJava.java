package io;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JumbleJava {
    private final Map<String, List<String>> wordMap;

    public JumbleJava() {
        try (var map =
                     Files.lines(Paths.get("src/main/resources/dict/words"))) {
            wordMap = map.filter(word -> word.length() == 5 || word.length() == 6)
                           .collect(Collectors.groupingBy(this::word2key));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public List<String> solve(String clue) {
        return wordMap.getOrDefault(word2key(clue), Collections.singletonList(""));
    }

    private String word2key(String word) {
        return Arrays.stream(word.split(""))
                     .sorted()
                     .collect(Collectors.joining());
    }

    public List<List<String>> parallelSolve(String... clues) {
        return Arrays.stream(clues)
                     .parallel()
                     .map(this::solve)
                     .collect(Collectors.toList());
    }
}
