public class Largest{

	public int largestNumber(int[] numbers){
	  int largest = 0;
	  
	for(int counter=0; counter<=numbers.length-1; counter++){
		if(numbers[counter] > largest){
		  largest = numbers[counter];
		}
	
	}
	return largest;
    }

	public int minimumNumber(int[] integers){
	int minimum = integers[0];
	for(int i=0; i<=integers.length-1; i++){
	 if(integers[i] < minimum){
	  minimum = integers[i];
	}
	}

	return minimum;

	}

}