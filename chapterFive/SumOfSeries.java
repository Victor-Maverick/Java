public class SumOfSeries{

  public static void main(String... args){

   long total = 1;
   System.out.print("n\tSum\n");
   for(int i = 1; i <= 100; i++){
     total *= i;  
   System.out.printf("%d	%d%n", i, total);
   } 



  }




}