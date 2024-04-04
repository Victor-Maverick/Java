public class SumList{

	public int forLoopSum(int[] myArray){

	int total = 0;
	for(int count=0; count<=myArray.length-1; count++){
	total+=myArray[count];
	}
	return total;
	}

	public int whileLoopSum(int[] array){
	
	int total = 0;
	int count = 0;
	while(count<=array.length-1){
	total+=array[count];
	count++;
	}
	return total;
	}

	public int doWhileSum(int[] newArray){
	
	int total=0;
	int count=0;
	 do{
	  total+=newArray[count];
	  count++;
	}while(count<=newArray.length-1);
	return total;
	}
}