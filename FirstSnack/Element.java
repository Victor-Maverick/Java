public class Element{

	public boolean findElement(int[] myArray, int numberOne){

	for(int count=0; count<=myArray.length-1; count++){
	  if(myArray[count] == numberOne){
	   return true;
	  }
	}

	return false;
	}

	public boolean findStringElement(String[] array, String object){
	for(int count=0; count<=array.length-1; count++){
	  if(array[count] == object){
	    return true;
	  }
	}
	return false;
	} 
	
}