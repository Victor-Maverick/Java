import java.util.Scanner;
public class AgeInDays{

public static void main(String[] args){

Scanner input = new Scanner(System.in);

System.out.println("Enter your age in years");
int ageInYears = input.nextInt();

int ageInDays = ageInYears * 365;


System.out.printf("%d days", ageInDays);



}

}






