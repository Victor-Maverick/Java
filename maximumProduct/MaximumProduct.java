package maximumProduct;

public class MaximumProduct {

    public int getMaximumProduct2Of(int[] array) {

        if (array.length < 2 ) return 0;
        int maximumProduct = Integer.MIN_VALUE;

        for (int count = 0; count < array.length-1; count++)
            for (int index = count+1; index < array.length; index++)
               if (array[count] * array[index] > maximumProduct) maximumProduct = array[count] * array[index];

        return maximumProduct;
    }

    public int[] filterZeroElements(int[] array) {
        if(array.length == 0) return new int[0];
        int[] result = new int[array.length];
        int counter = 0;
        for (int number : array) {
            if (number != 0) result[counter++] = number;
        }
       return result;
    }
}
