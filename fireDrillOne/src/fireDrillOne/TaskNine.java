package fireDrillOne;

public class TaskNine {
    public static void main(String[] args){
        double total = 0;
        double totalTwo = 0;
        for(int index = 1; index <=10; index++){
            for (int count = 1; count <= 5; count++) {
                if (index / 4 == 1 && index % 4 ==0) {
                    total += Math.pow(index, count);

                }
                else if(index / 4 == 2 && index % 4 ==0){
                    totalTwo += Math.pow(index, count);
                }
            }

        }
        double totalSum = total + totalTwo;
        System.out.printf("The square of the two sums is %.0f", (totalSum * totalSum));
    }
}
