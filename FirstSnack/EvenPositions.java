public class EvenPositions{

	public int[] evenElementsPositions(int[] numbers){

	int[] newArray = new int[numbers.length / 2];
	int count = 0;
	for (int index = 1; index<=numbers.length-1; index+=2){
		newArray[count] = numbers[index];	
		count++;
	}
	
	return newArray;
	}


}