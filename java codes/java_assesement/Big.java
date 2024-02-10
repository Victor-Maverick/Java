import java.util.Scanner;
public class Big{

public static void main(String[] args){

Scanner input = new Scanner(System.in);
System.out.println("Enter three integers: ");

int a = input.nextInt();
int b = input.nextInt();
int c = input.nextInt();

int sum = a + b + c;
int av = (a * b * c)/3;
int pd = a * b * c;


if (a<b<c){
System.out.printf("%d is the is the smallest num", a);
}
else if (b<a<c){
System.out.printf("%d is the smallest num", b);
}
else if (c<b<a){
System.out.printf("%d is the smallest num", c);

}

if (a>b>c){
System.out.printf("%d is the largest num", a);
}

else if (b>a>c){
System.out.printf("%d is the largest num");

}

else if (c>b>a){
System.out.printf("%d is the largest num");

}
System.out.printf("The Sum is %d, The average is %d, The product is %d%n", sum, av, pd );


}






}