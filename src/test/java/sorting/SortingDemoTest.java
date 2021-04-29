package sorting;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class SortingDemoTest {
    private SortingDemo demo = new SortingDemo();

    private void checkAlphabetical(List<String> strings) {
        strings.stream()
                .reduce("", (prev, curr) -> {
                            assertTrue(prev.compareTo(curr) <= 0);
                            return curr;
                        }
                );
    }

    private void checkLength(List<String> strings) {
        strings.stream()
                .reduce((prev, curr) -> {
                            assertTrue(prev.length() <= curr.length());
                            return curr;
                        }
                );
    }

    @Test
    public void testAlphaSort() throws Exception {
        checkAlphabetical(demo.alphaSort());
    }

    @Test
    public void testAlphaSortUsingStreams() throws Exception {
        checkAlphabetical(demo.alphaSortUsingStreams());
    }

    @SuppressWarnings("ComparatorMethodParameterNotUsed")
    @Test
    public void testLengthReverseSortWithComparator() throws Exception {
        List<String> strings = demo.lengthReverseSortWithComparator().stream()
                .sorted((s1, s2) -> -1)
                .collect(Collectors.toList());
        checkLength(strings);
    }

    @Test
    public void testLengthSortWithLambda() throws Exception {
        checkLength(demo.lengthSortWithLambda());
    }

    @Test
    public void testLengthSortUsingSorted() throws Exception {
        checkLength(demo.lengthSortUsingSorted());
    }

    @Test
    public void testLengthSortUsingComparator() throws Exception {
        checkLength(demo.lengthSortUsingComparator());
    }

    @Test
    public void testLengthSortThenAlphaSort() throws Exception {
        demo.lengthSortThenAlphaSort().stream()
                .reduce((prev, curr) -> {
                    if (prev.length() != curr.length()) {
                        assertTrue(prev.length() <= curr.length());
                    } else {
                        assertTrue(prev.compareTo(curr) <= 0);
                    }
                    return curr;
                });
    }

    @Test
    public void testLengthSortThenReverseAlphaSort() throws Exception {
        demo.lengthSortThenReverseAlphaSort().stream()
                .reduce((prev, curr) -> {
                    if (prev.length() != curr.length()) {
                        assertTrue(prev.length() <= curr.length());
                    } else {
                        assertTrue(prev.compareTo(curr) >= 0);
                    }
                    return curr;
                });
    }
}