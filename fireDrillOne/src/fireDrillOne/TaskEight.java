package fireDrillOne;

public class TaskEight {
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

        System.out.printf("The sum of the sums is %.0f", (total + totalTwo));
    }
}
