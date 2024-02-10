import java.util.Scanner; 
public class CreditCardValidator{
 private static String cardType;
 private static String cardNumber;
 private static int cardDigitLength;
 private static String cardValidityStatus;

  
  public static void setCardType(String cardNumber){
    
  char a = cardNumber.charAt(0);
  char b = cardNumber.charAt(1);

 if (a == '4'){
   cardType = "Visa";
  }
  else if(a == '5'){
	cardType = "MasterCard";
  }
  else if(a == '6'){
   	cardType = "Discover";
  }
  else if(a == '3' && b == '7'){
  	cardType = "American Express";
  }
  else{
        cardType = "Invalid card";
  }  
  }

  public static String getCardType(){
   return cardType;

  }

  public static void setCardNumber(){
  Scanner input = new Scanner(System.in);
  System.out.println("Hello, enter your card number: ");
  cardNumber= input.next();

  while(cardNumber.length()< 13 || cardNumber.length() > 16){
     System.out.println("Card number should be 13-16 digits, Enter card Number again: ");
     cardNumber= input.next();
    }
  }

  public static String getCardNumber(){

     return cardNumber;
  }

  public static void setDigitLength(String cardNumber){
    cardDigitLength = cardNumber.length();
  }

  public static int getDigitLength(){
  return cardDigitLength;
 
}


public static void setValidityStatus(String cardNumber){
 int length = cardNumber.length();
 long varLong = Long.valueOf(cardNumber);
 int[] myArray = new int[length];
 
 for(int index = myArray.length-1; index >= 0; index--){
	  myArray[index] = (int)(varLong%10);
	  varLong /= 10;
	  System.out.printf("%d", myArray[index]);
}

int[] newArray = new int[myArray.length/2];
int counter = 0;
for(int count=myArray.length-2; count>=0; count-=2){
  newArray[counter] = myArray[count] * 2;
 counter++;  
}
  

int[] avArray = new int[newArray.length];
int y = 0;
for(int count=0; count<newArray.length; count++){
  
if(newArray[count]>=10){
 avArray[y] = newArray[count]/10 + newArray[count]%10;
 }else{
  avArray[y] = newArray[count];
 }	 
 y++;
}


int total1 =0;

for(int i = avArray.length-1; i>=0; i--){
  total1+=avArray[i];
}

int total2=0;
for(int count = myArray.length-1; count>=0; count-=2){
total2+=myArray[count];
} 

int totals =  total1 + total2;

if (totals % 10 == 0){
cardValidityStatus = "Valid Card";
}
else if(totals % 10 != 0) {
  cardValidityStatus = "Invalid Card";
}

}

public static String getValidityStatus(){
  return cardValidityStatus;
}
public static void main(String[] args){
  setCardNumber();
  setCardType(cardNumber);
  setDigitLength(cardNumber);
  setValidityStatus(cardNumber);

  System.out.println("*********************************************");
  System.out.printf("**Credit Card Type: %s%n**Credit Card Number: %s%n**Credit Card Digit Length: %d%n**Credit Card Validity Status: %s%n", getCardType(), getCardNumber(), getDigitLength(), getValidityStatus());
  System.out.println("*********************************************");
}
}