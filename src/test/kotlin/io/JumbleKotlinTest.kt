package io

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
                { assertEquals("actual", jumbleKotlin.solve("cautla")[0]) },
                { assertEquals("goalie", jumbleKotlin.solve("agileo")[0]) },
                { assertEquals("mumble", jumbleKotlin.solve("mmlueb")[0]) }
        )
    }

    @ParameterizedTest(name = "{0} unscrambles to {1}")
    @CsvSource("cautla, actual",
        "agileo, goalie", "mmlueb, mumble")
    fun `unscramble words`(clue: String, answer: String) =
            assertEquals(jumbleKotlin.solve(clue)[0], answer)

    @Test
    internal fun `check solveAll`() {
        assertEquals(listOf("actual", "goalie", "mumble"),
                jumbleKotlin.solveAll("cautla", "agileo", "mmlueb").map { it[0] })
    }
}