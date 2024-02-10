public class OddPositions{
	public int[] positionElements(int[] numbers){
	int[] newArray = new int[numbers.length/2];
	int index = 0;
	for (int count=0; count<=numbers.length-1; count+=2){
		newArray[index] = numbers[count];
		index++;	  
	}

	return newArray;
	}

	
}