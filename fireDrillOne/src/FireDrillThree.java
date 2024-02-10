
public class FireDrillThree {

    public int[] taskOne(int... numbers) {

        int[] myArray = new int[numbers.length];

        for (int count = 0; count < 10; count++) {
            myArray[count] = numbers[count];

        }

        return myArray;
    }

    public String taskTwo(int... numbers) {

        int[] myArray = new int[numbers.length];
        String merge = "";
        String newLine = "\n";

        for (int count = 0; count < 10; count++) {
            myArray[count] = numbers[count];
            merge += myArray[count] + newLine;
        }

        return merge;
    }

    public String taskThree(int... numbers) {

        int[] myArray = new int[numbers.length];
        String merge = "";

        for (int count = 0; count < 10; count++) {
            myArray[count] = numbers[count];
            merge += myArray[count] + " ";
        }

        return merge;
    }

    public int[] taskFour(int[] array){

        int[] oddIndexArray = new int[array.length / 2];
        int index = 0;
        for(int count = 1; count < array.length; count +=2){
            oddIndexArray[index] = array[count];
            index++;
        }
        return oddIndexArray;
    }

    public int[] taskFive(int[] array){

        int length;
        if (array.length % 2 == 1) {
            length = (array.length / 2 + 1);
        }else{
            length = array.length / 2;
        }
        int[] evenIndexArray = new int[length];

        int index = 0;
        for(int count = 0; count < array.length; count +=2){
            evenIndexArray[index] = array[count];
            index++;
        }
        return evenIndexArray;
    }

    public int taskSix(int[] array){

        int[] oddIndexArray = new int[array.length / 2];

        int sum = 0;
        int index = 0;
        for(int count = 1; count < array.length; count +=2){
            oddIndexArray[index] = array[count];
            sum += oddIndexArray[index];
            index++;
        }
        return sum;
    }

    public int taskSeven(int[] array){

        int length;
        if (array.length % 2 == 1) {
            length = (array.length / 2 + 1);
        }else{
            length = array.length / 2;
        }
        int[] evenIndexArray = new int[length];
        int sum = 0;
        int index = 0;
        for(int count = 0; count < array.length; count +=2){
            evenIndexArray[index] = array[count];
            sum += evenIndexArray[index];
            index++;
        }
        return sum;
    }

    public int taskEight(int[] array){

        int[] oddIndexArray = new int[array.length / 2];

        int minimum = array[0];
        int index = 0;
        for(int count = 1; count < array.length; count +=2){
            oddIndexArray[index] = array[count];
            if (oddIndexArray[index] < minimum){
                minimum = oddIndexArray[index];
            }
            index++;
        }

        return minimum;
    }

    public int taskNine(int[] array){

        int length;
        if (array.length % 2 == 1) {
            length = (array.length / 2 + 1);
        }else{
            length = array.length / 2;
        }
        int[] evenIndexArray = new int[length];
        int minimum = array[0];
        int index = 0;
        for(int count = 0; count < array.length; count +=2){
            evenIndexArray[index] = array[count];
            if (evenIndexArray[index] < minimum)
                minimum = evenIndexArray[index];
            index++;
        }
        return minimum;
    }

    public int taskTen(int[] array) {
        int[] oddIndexArray = new int[array.length / 2];

        int maximum = 0;
        int index = 0;
        for(int count = 1; count < array.length; count +=2){
            oddIndexArray[index] = array[count];
            if (oddIndexArray[index] > maximum){
                maximum = oddIndexArray[index];
            }
            index++;
        }

        return maximum;
    }

    public int taskEleven(int[] array) {

        int length;
        if (array.length % 2 == 1) {
            length = (array.length / 2 + 1);
        }else{
            length = array.length / 2;
        }
        int[] evenIndexArray = new int[length];
        int maximum = 0;
        int index = 0;
        for(int count = 0; count < array.length; count +=2){
            evenIndexArray[index] = array[count];
            if (evenIndexArray[index] > maximum)
                maximum = evenIndexArray[index];
            index++;
        }
        return maximum;
    }

    public int[] taskTwelve(int[] array) {
        int[] newArray = new int[array.length];

        int index = 1;
        for(int count = 0; count < array.length; count += 2){
            newArray[index] = array[count];
            index+=2;
        }
        int count = 0;
        for(int counter = 1; counter < array.length; counter += 2){
            newArray[count] = array[counter];
            count += 2;
        }
        return newArray;

    }


    public int[] taskThirteen(int[] array) {

        int temp = 0;
        for(int count = 0; count < array.length; count += 2){
            for(int index = count + 1; index < array.length; index+=2){
                if(array[count] % 2 == 0 || array[index] % 2 == 0){
                    array[count] = array[count];
                }
                else {
                    temp = array[count];
                    array[count] = array[index];
                    array[index] = temp;
                }
            }
        }
        return array;
    }

    public int[] taskFourteen(int[] array) {
        int temp = 0;
        for(int count = 0; count < array.length; count += 2){
            for(int index = count + 1; index < array.length; index+=2){
                if(array[count] % 2 == 1 || array[index] % 2 == 1){
                    array[count] = array[count];
                }
                else {
                    temp = array[count];
                    array[count] = array[index];
                    array[index] = temp;
                }
            }
        }
        return array;
    }

    public int[] taskFifteen(int[] array) {
        int temp = 0;
        for(int count = 0; count < array.length; count += 2){
            for(int index = count + 1; index < array.length; index+=2){
                if(array[count] % 2 != 0 && array[index] % 2 != 0){
                    array[count] = array[count];
                    break;
                }
                else {
                    temp = array[count];
                    array[count] = array[index];
                    array[index] = temp;
                    break;
                }
            }
        }
        return array;
    }

    public int[] taskSixteen(int[] array) {
        int temp = 0;
        for(int count = 0; count < array.length; count += 2){
            for(int index = count + 1; index < array.length; index+=2){
                if(array[count] % 2 == 0 && array[index] % 2 == 0){
                    array[count] = array[count];
                    break;
                }
                else {
                    temp = array[count];
                    array[count] = array[index];
                    array[index] = temp;
                    break;
                }
            }
        }
        return array;

    }
}
