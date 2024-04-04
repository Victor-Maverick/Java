

public class ThreeDivisibles {
    public int calculateSumOfThreeDivisibles() {
        int sum = 0;
        for (int count = 1; count <= 30; count++){
            if(count % 3 == 0){
                sum += count;
            }
        }
        return sum;
    }
}
