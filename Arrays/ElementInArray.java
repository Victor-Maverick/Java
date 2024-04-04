public class ElementInArray{

  public static void arrayElementCheck(int[] array, int element){

  int index = 0;
  for(index = 0; index < array.length-1; index++){
   if (array[index] == element){
	System.out.print("It is there");
	break;
	}
   }
 System.out.print("E didnt dy");
 }

  public static void main(String[] args){

   int[] array = {23, 32, 41, 24, 50, 33};
   arrayElementCheck(array, 4);

   

  }
}