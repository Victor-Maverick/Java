package myPackage;

public class Practice {

    public boolean checkSumOfNumbers(int... numbers) {
        int sum = 0;
        for(int count = 0; count < numbers.length; count++){
            if(count == 0)continue;
            sum += numbers[count];
            if(sum >= numbers[0]) {
                return true;

            }
        }
        return false;
    }

    //public boolean checkIfSumIsEqualOrGreater(){return isEqualOrGreater;}
}
