package streams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SumNumbersTest {
    @Test
    void getTotal() {
        int total = SumNumbers.getTotal(
                List.of(3, 1, 4, 1, 5, 9, 2, 6, 5));
        assertEquals(2 * (3 + 9 + 6), total);
    }
}