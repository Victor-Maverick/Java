package minMax;

import java.util.Arrays;

public class MinMax {

    public int[] calculateMinMax(int[] array) {
        array = Arrays.stream(array).sorted().toArray();
        int[] minMaxList = new int[2];
        for(int count = 0; count < array.length; count++){
            if(count != 0) minMaxList[1] += array[count];
            if(count != array.length - 1) minMaxList[0] += array[count];
        }
        return minMaxList;
    }

    //return new int[]{Arrays.stream(numbers).sum()- Arrays.stream(numbers).min().getAsInt};
}
