public class DiamondShape{
  public static void main(String[] args){
   diamondPattern(5);
}
  public static void diamondPattern(int n){
    for(int row = 0; row < 2*n; row++){
      int c = row>n? 2*n-row: row; 
      int s = n-c;
       for(int space=0; space<s; space++){
         System.out.print(" ");
       } 
       
       for(int column=0; column<c; column++){
         System.out.print("* ");
       }
       System.out.println();
    }
    
  }

}