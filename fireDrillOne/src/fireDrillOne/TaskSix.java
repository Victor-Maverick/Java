package fireDrillOne;

public class TaskSix {

    public static void main(String[] args){
        for(int index = 1; index <=10; index++){
            for (int count = 1; count <= 5; count++) {
                if (index % 4 == 0) {
                        System.out.printf("%.0f ", Math.pow(index, count));

                }
            }
        }

    }
}
