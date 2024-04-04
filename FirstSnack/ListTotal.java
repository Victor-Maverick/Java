public class ListTotal{

	public int listTotal(int[] array){
		int total = 0;
		for (int index=0; index<=array.length-1; index++){
		total+=array[index];
		
		}
	return total;
	}
}