import java.util.Scanner;
public class Triangle1{

	public int lengthOfTriangle(){

	Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of a triangle: ");
	int length = scanner.nextInt();

	 if (length > 0 || length > 10){

	   System.out.println("Invalid input, Enter a number between 1 and 10");
	    length = scanner.nextInt();
	}

return length;
	     
          
}
	
	public void drawRightAngledTriangle(int length){
	  for (int row=1; row<=length; row++){

	  	for(int rowOut=1; rowOut <= row; rowOut++){
		  System.out.print("* ");

		}
	  System.out.println();
	  }
	}


}