public class Dare{
  public static void main(String[] args){
   for (int i = 1; i <= 10; i++){
      for(int j = 1; j<=i; j++){
         System.out.print("*");	
      }
         System.out.println();
   }

    for (int k = 1; k<=10; k++){
      for (int l = 10; l >= k; l--){
        System.out.print("*");
      }
        System.out.println();
     
    }

     for (int m = 1; m<=10; m++){
       for (int n = m; n<=10; n++){
           System.out.print(' ');
         }
          for (int n = 1; n<=m; n++){
           System.out.print("*");
          }
           System.out.println();
      } 

     for (int o =1; o<=10; o++){
        for (int p=1; p<=o; p++){
         System.out.print(' ');
        }
        for (int p=o; p<=10; p++){
          System.out.print("*");
         }
         System.out.println();

     }


  }





}