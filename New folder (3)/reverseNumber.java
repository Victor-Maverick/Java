import java.util.Scanner;
public class reverseNumber{

  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
 
     System.out.println("Enter a five digit number: ");
     String number = input.next();

     while(number.length() != 5){

       System.out.println("Enter a five digit number: ");
        number = input.next();

     }

     String reverseNumber = "";
    
       for(int count = 4; count >= 0; count--){
	 reverseNumber += number.charAt(count);
       }
     
     System.out.println(reverseNumber);

  }


}