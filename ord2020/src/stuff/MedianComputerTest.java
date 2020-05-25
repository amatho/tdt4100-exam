package stuff;

import org.junit.Test;
import java.util.List;
import org.junit.Assert;


public class MedianComputerTest {

    // use as third argument to Assert.assertEquals(double, double, double) method for handling round-off errors
    // e.q. Assert.assertEquals(6.0, MedianComputer.compute(...), roundErrorDelta);
    double roundErrorDelta = 0.00000001;

    @Test
    public void testCompute1() {
        Assert.assertEquals(6, MedianComputer.compute(List.of(1d, 3d, 3d, 6d, 7d, 8d, 9d)), roundErrorDelta);
    }

    @Test
    public void testCompute2() {
        Assert.assertEquals(4.5, MedianComputer.compute(List.of(1d, 2d, 3d, 4d, 5d, 6d, 8d, 9d)), roundErrorDelta);
    }

    @Test
    public void testComputeSingle() {
        Assert.assertEquals(42, MedianComputer.compute(List.of(42d)), roundErrorDelta);
    }

    @Test
    public void testComputeTwoElements() {
        Assert.assertEquals(3.5, MedianComputer.compute(List.of(3d, 4d)), roundErrorDelta);
    }

    @Test
    public void testFails() {
        try {
            MedianComputer.compute(null);
            MedianComputer.compute(List.of());
        } catch (IllegalArgumentException e) {}
    }
}
