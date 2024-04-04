package highestInArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class HighestInArray {
    public int[] getHighestOccurringIn(int[] inputArray) {

        int[] newArray = new int[2];
        int[] counts = new int[inputArray.length];

        for(int count = 0; count < inputArray.length; count++){
            for (int number : inputArray) {
                if (inputArray[count] == number) counts[count] += 1;
            }
        }
        int highest = 0;
        for(int ind = 0; ind < counts.length; ind++){
            if(counts[ind] > highest) {
                highest = counts[ind];
                newArray[1] = inputArray[ind];
                newArray[0] = highest;
            }
        }

        return newArray;
    }
}
