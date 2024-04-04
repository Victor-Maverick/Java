import java.util.Arrays;
public class StringPalindrome{

  public static void main(String[] args){
   String word = "hannoh";
   int length = word.length();
   String[] array = new String[length];

   int index = 0;
   for(int count = 0; count < length; count++){
     array[index] = word.charAt(count) + " ";
      index++;
   } 
    System.out.println(Arrays.toString(array)); 

    int ind = 0;
    boolean correct = true;

   for(int count = array.length-1; count >= 0; count--){
      
     if(array[count] == array[ind]){
       ind++;
       System.out.println("this is a palindrome");
     }
      
   }  
  }

}
