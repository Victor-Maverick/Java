public class TaskZero{

	public int[] squareElelments(int[] myArray){
	
	int[] arrays = new int[myArray.length];
	int count = 0;
	 for(int index=0; index<=myArray.length-1; index++){
	  if (myArray[index]>=-100 && myArray[index]<=100){
	   arrays[count]= myArray[index]*myArray[index];
	   count++;
	  }
	 }
	return arrays;
	}
}