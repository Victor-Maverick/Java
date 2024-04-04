import java.util.Scanner;

public class Asterisk{

public static void main(String... args){

Scanner input = new Scanner ( System.in);

int counter = 1;
 
System.out.println( "enter your triangle base "); 

int number = input.nextInt();

while ( counter < number) { 

     int newCounter = 1;
   while ( newCounter <= counter ) { 
 
  System.out.print ("*") ; 
  newCounter++ ;   }

        
System.out.println("");

counter ++;}
               }
                   }
