public class Print{
  public static void main(String[] args){
   
  for(int count=0; count<10; count++){
    for(int index=0; index<=count; index++){
      System.out.print("*");
    }
     System.out.println();
  }

    System.out.println();

  for(int count=0; count<10; count++){
    for(int index=10; index>count; index--){
      System.out.print("*");
    }
    System.out.println();
  }

  System.out.println();  

  for(int count=0; count<10; count++){
    for(int index=0; index<=count; index++){
     System.out.print(" ");
    }
   
    for(int num=10; num>count; num--){
      System.out.print("*");
    }
      System.out.println();
  }

  System.out.println();

   for(int count=0; count<10; count++){
     for(int space=10; space>count; space--){
       System.out.print(" ");
     }

     for(int index=0; index<=count; index++){
       System.out.print("*");
     }
       System.out.println();
   }

  }

}