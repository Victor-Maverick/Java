public class Array2{

	public static void main(String[] args){

	int[] newArray = new int[]{10, 20,  30, 40, 50, 60, 70};
	int length = newArray.length-1;
	int half = length/2;
	
	for(int i =0; i<=newArray.length; i++){
	if (i==half) 	
	System.out.print(newArray[i]);
	}

	int total=0;
	int average=0;
	for (int j=0; j<newArray.length; j++){
	total+=newArray[j];
	
	}
	average =  total/ newArray.length;
	System.out.printf("The mean of the array is: %d", average);

	}


}