package sequences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class SumNumbersTest {

    @Test
    fun `total should be 36`() {
        assertAll(
                { assertEquals(36, getTotal(listOf(3, 1, 4, 1, 5, 9, 2, 6, 5))) },
                { assertEquals(36, getTotalUsingSequences(listOf(3, 1, 4, 1, 5, 9, 2, 6, 5))) }
        )
    }
}