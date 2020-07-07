package io;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JumbleJavaTest {
    private final JumbleJava jumble = new JumbleJava();

    @Test
    void checkSolver() {
        assertAll(
                () -> assertEquals("actual", jumble.solve("cautla")),
                () -> assertEquals("goalie", jumble.solve("agileo"))
        );
    }

    @Test
    void checkParallelSolve() {
        List<String> strings = jumble.parallelSolve("zaaem", "rwdoc", "tlufan");
        System.out.println(strings);
        assertThat(strings, containsInAnyOrder("amaze", "crowd", "flaunt"));
        System.out.println(jumble.parallelSolve("snsaoe", "craigl", "ssevur",
                "lonelp", "nlahed", "ceitkl"));
    }
}