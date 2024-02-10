import java.security.SecureRandom;
public class ModifiedDiamond{

  public static void diamondPattern(){
    
    SecureRandom random = new SecureRandom();
    
    int n = 0;
    int loopSize = random.nextInt(1, 20);
    
    while(loopSize % 2 == 0){
      loopSize = random.nextInt(1, 20);
    }

    System.out.println(loopSize);
    if(loopSize % 2 != 0){
     n = (loopSize / 2) + 1;
     }
     
   
    for(int count = 0; count < 2 * n + 1; count++){
      int noOfColumns = count > n ? 2 * n - count : count;

      int spaces = n - noOfColumns; 
	for(int index = 0; index < spaces; index++){
 	  System.out.print(" ");
	}   
        for(int ind = 0; ind < noOfColumns; ind++){
	  System.out.print("* ");
	}   
	System.out.println();
    }
  }

  public static void main(String[] args){
   diamondPattern();
  }

}