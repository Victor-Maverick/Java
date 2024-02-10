import java.util.Scanner;
public class Pure{

public static void main(String[] args){

Scanner input = new Scanner(System.in);
System.out.println("Enter a number");
int num = input.nextInt();

if (num%5==0 && num%6==0){
System.out.printf("is %d divisible by 5 and 6? true %n", num);
System.out.printf("is %d divisible by 5 or 6? true %n", num);
System.out.printf("is %d divisible by 5 or 6? false  but not both%n", num);
}

if (num%5!=0 && num%6==0){
System.out.printf("is %d  divisible by 5 and 6? false%n", num);
System.out.printf("is %d divisible by 5 or 6? true %n", num);
System.out.printf("is %d divisible by 5 or 6? true  but not both%n", num);
}

if (num%5==0 && num%6!=0){
System.out.printf("is %d divisible by 5 and 6 ?false%n", num);
System.out.printf("is %d divisible by 5 or 6? true %n", num);
System.out.printf("is %d divisible by 5 or 6? true  but not both%n", num);
}

if (num%5!=0 && num%6!=0){
System.out.printf("is %d divisible by 5 and 6 ?false%n", num);
System.out.printf("is %d divisible by 5 or 6? false%n", num);
System.out.printf("is %d divisible by 5 or 6? false  but not both%n", num);
}


}


}