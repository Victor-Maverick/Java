import java.util.*;
   public class HeadOrTail{
 
   public static void main(String... args){

   Scanner input = new Scanner(System.in);
   int coin = (int) (Math.random() * 2);
   
   System.out.print("Enter a guess 0-head or 1-tail: ");
   int guess = input.nextInt();

   System.out.println(((guess == coin) ? "Correct" : "Incorrect") + "guess");

 }







}