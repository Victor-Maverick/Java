public class TableArrangement{

  public static void main(String... args){
  
   System.out.printf("%-10s %-10s %-10s %-10s %n", "N", "N2", "N3", "N4");
   
   System.out.println();

   for (int i =1; i<=5; i++){
   int square =i * i;
   int cube = i * i * i;
   int quadriple = i * i * i * i;

   System.out.printf("%-10d %-10d %-10d %-10d %n", i, square, cube, quadriple);

   }





  }









}