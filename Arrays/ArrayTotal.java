public class ArrayTotal{

  public static int intArrayTotal(int[] myArray){
  
    int arrayTotal = 0;
     for(int elements: myArray){
       arrayTotal += elements;
     }
      return arrayTotal;
  }

  public static void main(String... args){
    int[] array = {33, 34, 54, 32, 24, 29};
    System.out.printf("The running total of elements int the list is %d", intArrayTotal(array));
  }
}