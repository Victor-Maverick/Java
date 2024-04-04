public class Twos{

  public static void main(String[] args){

  System.out.print("number\tsquare\tcube\tquad\n");

  for (int i = 1; i <= 5; i++){
   int square = i * i;
   int cube = i * i * i;
   int quadruple = i * i * i * i;
   
   System.out.printf("%d	%d	%d	%d%n", i, square, cube, quadruple);



   }


  }




}