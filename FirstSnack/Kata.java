public class Kata{

	public int[] reverse(int[] numbers){
		int[] newArray = new int[numbers.length];
		int count = 0;
		for(int index=numbers.length-1; index>=0; index--){
		newArray[count] = numbers[index];
		count++;
		}

	return newArray;
	}


}