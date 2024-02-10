import java.util.Scanner;
public class Numero{
	public static void main(String[] args){

	Scanner scanner = new Scanner(System.in);

	System.out.println("Enter two numbers ");
	int x = scanner.nextInt();
	int y = scanner.nextInt();

	int tripledX = x * 3;
	int doubledY = y * 2;
	
	if (tripledX % doubledY == 0)
System.out.printf("%d tripled is a multiple of %d doubled", x, y);
	

	else  
	System.out.printf("%d tripled is not a multiple of %d doubled", x, y);

	
}


}