public class AddforMultiplication{

  public int MultiplicatinValue(int number1, int number2){
  
    int total = 0;
    int length = (int)Math.abs(number2);

    if(number2 < 0 && number1 > 0){
      
      for(int count = 1; count <= length; count++){
  
        total += (int)Math.abs(number1);    
      }
    	total *= -1;
    }
    else if(number1 < 0 && number2 > 0){
      
      for(int count = 1; count <= length; count++){
  
        total += (int)Math.abs(number1);    
      }
    	total *= -1;
    }
    else if(number2 < 0 && number1 < 0){
      
      for(int count = 1; count <= length; count++){
  
        total += (int)Math.abs(number1);    
      }
    
    }
    else{
       for(int count = 1; count <= length; count++){
  
        total += number1;    
       }
    }
   return total;

  }





}