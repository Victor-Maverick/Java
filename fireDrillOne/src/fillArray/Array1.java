package fillArray;

import java.util.Arrays;

public class Array1 {
    public static void main(String[] args) {

        int[] array = {4, 5, 8, 10};
        int[] filledArray = fillArray(array);
        System.out.println(Arrays.toString(filledArray));

    }
    public static int[] fillArray(int[] array){
        int[] newArray = new int[array.length * 2];
        addElementsToFirstIndices(array, newArray);
        addElementsToRemainingIndicesInList(array, newArray);
        return newArray;
    }
    public static void addElementsToFirstIndices(int[] array, int[] newArray){

        for (int count = 0; count < array.length; count++) newArray[count] = array[count];

    }
    public static void addElementsToRemainingIndicesInList(int[] array, int[] newArray){
        int counter = 0;
        for (int index = array.length; index < newArray.length; index++){
            newArray[index] = array[counter] * 2;
            counter++;
        }
    }

}
