package stuff;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SummerTest {

    @Test
    public void testSum1() {
        Assert.assertEquals(6, Summer.sum(List.of(1, 2, 3)));
    }

    @Test
    public void testSumMistake() {
        Assert.assertEquals(0, Summer.sum(List.of()));
    }

    @Test
    public void testSumMistakeIterable() {
        Iterable<Integer> iterable = List.of();
        Assert.assertEquals(0, new Summer().sum(iterable));
    }

    @Test
    public void testDifference1() {
        Assert.assertEquals(0, Summer.difference(List.of(6, 1, 2, 3)));
    }

    // Should throw IllegalArgumentException
    @Test
    public void testDifferenceMistake() {
        try {
            Summer.difference(List.of());
        } catch (IllegalArgumentException e) {}
    }
}
