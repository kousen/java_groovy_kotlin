package astro

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AstroRequestTest {

    @Test
    fun execute() {
        val result = AstroRequest().execute()
        println(result)

        assertAll(
            { assertEquals("success", result.message) },
            { assertTrue(result.number.toInt() >= 0) },
            { assertEquals(result.number.toInt(), result.people.size) }
        )
    }
}