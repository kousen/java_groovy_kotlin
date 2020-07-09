package io

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class JumbleKotlinTest {
    private val jumbleKotlin: JumbleKotlin = JumbleKotlin()

    @Test
    fun `check solver`() {
        assertAll(
                { assertEquals("actual", jumbleKotlin.solve("cautla")) },
                { assertEquals("goalie", jumbleKotlin.solve("agileo")) },
                { assertEquals("mumble", jumbleKotlin.solve("mmlueb")) }
        )
    }

    @ParameterizedTest(name = "{0} unscrambles to {1}")
    @CsvSource("cautla, actual",
        "agileo, goalie", "mmlueb, mumble")
    fun `unscramble words`(clue: String, answer: String) =
            assertThat(jumbleKotlin.solve(clue), `is`(answer))

    @Test
    internal fun `check solveAll`() {
        assertEquals(listOf("actual", "goalie", "mumble"), jumbleKotlin.solveAll("cautla", "agileo", "mmlueb"))
    }
}