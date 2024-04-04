public class DiamondPrints{

  public static void main(String[] args){

   for(int i = 1; i <=9; i+=2){
     for(int j =5; j >=1; j--){
      
       System.out.print(' ');
      for(int k =1; k >=j; k++){
       System.out.print("*");

       }

      }
       
       System.out.println();
    }


  }


}