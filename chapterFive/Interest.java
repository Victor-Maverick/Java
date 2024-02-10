public class Interest{

  public static void main(String[] args){

   double principal = 1000.0;
   //double rate = 0.05;

     System.out.printf("Year\tRate\tAmount on deposit\n");
     for (int year = 1; year <= 10; ++year){
        for(double rate = 0.05; rate <= 0.10; rate+= 0.01){

       double amount = principal * Math.pow(1.0 + rate, year);

       System.out.printf("%d	%.2f	%.2f%n", year, rate, amount);
     }
  }

 }


}