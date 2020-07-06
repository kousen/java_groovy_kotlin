package io

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class JumbleTest {
    private val jumble: Jumble = Jumble()

    @Test
    fun `check solver`() {
        assertAll(
                { assertEquals("actual", jumble.solve("cautla")) },
                { assertEquals("goalie", jumble.solve("agileo")) },
                { assertEquals("mumble", jumble.solve("mmlueb")) }
        )
    }

    @ParameterizedTest(name = "{0} unscrambles to {1}")
    @CsvSource("cautla, actual",
        "agileo, goalie", "mmlueb, mumble")
    fun `unscramble words`(clue: String, answer: String) =
            assertThat(jumble.solve(clue), `is`(answer))

    @Test
    internal fun `check solveAll`() {
        assertEquals(listOf("actual", "goalie", "mumble"), jumble.solveAll("cautla", "agileo", "mmlueb"))
    }
}