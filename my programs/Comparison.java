import java.util.Scanner;
public class Comparison{
	public static void main(String[] args){

	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter a number ");
	int x = scanner.nextInt();

	int square = x * x;

	if (x < 100 && square < 100){
	System.out.printf("%d and %d are less than 100", x, square);
	}

	if (x > 100 && square > 100){
	System.out.printf("%d and %d are greater than 100", x, square);
	}

	if (x == 100 && square == 100){
	System.out.printf("%d and %d are equal to 100", x, square);
	}

	if (x != 100 && square != 100){
	System.out.printf("%d and %d are not equal to 100", x, square);
	}

}




}