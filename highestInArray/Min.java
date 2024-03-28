package highestInArray;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Min {

    public int[] getMinMaxDifference(int[] inputArray) {
        int i = IntStream.of(inputArray).max().getAsInt() - IntStream.of(inputArray).min().getAsInt();
        return new int[]{i};
    }

    public int[] getDifference(int[] input2) {
        int highest = 0;
        int lowest = input2[0];
        for (int number : input2) {
            if (number > highest) highest = number;
            if (number < lowest) lowest = number;
        }

        return new int[]{highest - lowest};
    }
}
