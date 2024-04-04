public class ReturnList{

	public int[] listElements(int myNumber){

	int num = myNumber;
	String numStr = num +"";
	int length = numStr.length();

	int[] array = new int[length];
	

	for(int index=length-1; index>=0; index--){
	  array[index] = num%10;
	  num/=10;
	}
	return array;
	}
}