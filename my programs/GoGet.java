import java.util.Scanner;

public class GoGet{

	public static void main(String[] args){ 

	Scanner pat = new Scanner(System.in);

	System.out.println("Enter 5 numbers: ");
	int a = pat.nextInt();
	int b = pat.nextInt();
	int c = pat.nextInt();
	int d = pat.nextInt();
	int e = pat.nextInt();


if (a>b && a>c && a>d && a>e){
System.out.printf("%d is the Largest number%n", a);
}

if (b>a && b>c && b>d && b>e){
System.out.printf("%d is the Largest number%n", b);
}

if (c>a && c>b && c>d && c>e){
System.out.printf("%d is the Largest number%n", c);
}

if (d>a && d>b && d>c && d>e){
System.out.printf("%d is the Largest number%n", d);
}

if (e>a && e>b && e>c && e>d){
System.out.printf("%d is the Largest number%n", d);
}

if (a<b && a<c && a<d && a<e){
System.out.printf("%d is the Smallest number", a);
}

if (b<a && b<c && b<d && b<e){
System.out.printf("%d is the Smallest number", b);
}

if (c<a && c<b && c<d && c<e){
System.out.printf("%d is the Smallest number", c);
}

if (d<a && d<b && d<c && d<e){
System.out.printf("%d is the Smallest number", d);
}

if (e<a && e<b && e<c && e<d){
System.out.printf("%d is the Smallest number", e);
}

}





}