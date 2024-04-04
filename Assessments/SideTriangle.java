public class SideTriangle{
  public static void main(String[] args){
    
   for(int count=4; count>0; count--){

    System.out.print("\t");  
     for(int index=0; index<10; index++){
       for(int num=0; num<= index; num++){
        System.out.print("*");
       }
       System.out.println();
     }
   }




  }

}