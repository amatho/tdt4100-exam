package stuff;

import java.util.List;

public class MedianComputer {
    public static double compute(List<Double> doubles) {
        if (doubles == null) {
            throw new IllegalArgumentException();
        }

        var size = doubles.size();
        if (size == 0) {
            throw new IllegalArgumentException();
        }

        if (size % 2 == 0) {
            var index = (size / 2) - 1;
            return (doubles.get(index) + doubles.get(index + 1)) / 2d;
        } else {
            var index = size / 2;
            return doubles.get(index);
        }
    }
}
