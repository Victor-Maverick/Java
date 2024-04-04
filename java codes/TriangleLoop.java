public class TriangleLoop{

  public static void main(String... quiba){

   for (int i=1; i<=10; i++){
     for(int j= i; j<=9; j++){
       System.out.print(' ');
        }
        for(int j = 1; j <=i; j++){
         System.out.print("*");   
     } 
    System.out.println();   
   }

   for (int k =1; k<=10; k++){
     for(int l =1; l<=k; l++){
      System.out.print(' ');
     }
     for(int l = k; l<=10; l++){
      System.out.print("*");
     }


      System.out.println();

    }




  }




}