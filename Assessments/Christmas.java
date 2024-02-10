import java.util.Scanner;
  public class Christmas{

  public static void main(String[] args){

  Scanner scanner = new Scanner(System.in);

  System.out.println("Enter a day of Christmas: ");
  int dayOfChristmas = scanner.nextInt();

  while (dayOfChristmas >= 1 && dayOfChristmas <= 12 && dayOfChristmas != -1){
  switch(dayOfChristmas / 1){
  case 1:
   System.out.println("On the first day of Christmas my true love sent to me ");
   break;
  case 2:
   System.out.println("On the second day of Christmas my true love sent to me ");
    break;
  case 3:
   System.out.println("On the third day of Christmas my true love sent to me ");
    break;
  case 4:
   System.out.println("On the fourth day of Christmas my true love sent to me ");
    break;
  case 5:
   System.out.println("On the fifth day of Christmas my true love sent to me ");
    break;
  case 6:
   System.out.println("On the sixth day of Christmas my true love sent to me ");
    break;
  case 7:
   System.out.println("On the seventh day of Christmas my true love sent to me ");
   break;
  case 8:
   System.out.println("On the eighth day of Christmas my true love sent to me ");
     break;
  case 9: 
  System.out.println("On the ninth day of Christmas my true love sent to me ");
    break;
  case 10: 
  System.out.println("On the tenth day of Christmas my true love sent to me ");
     break;
  case 11:
   System.out.println("On the eleventh day of Christmas my true love sent to me ");
  break;
  case 12:
   System.out.println("On the twelfth day of Christmas my true love sent to me ");
  }

System.out.println("Enter the day number of Christmas for your gift: ");
  int giftOfChristmas = scanner.nextInt();

  switch(giftOfChristmas / 1){
  case 1:
   System.out.println("A partridge in a pear tree");
   break;
  case 2:
   System.out.println("Two turtle doves");
    break;
  case 3:
   System.out.println("Three French hens");
    break;
  case 4:
   System.out.println("Four calling birds");
    break;
  case 5:
   System.out.println("Five Golden rings");
    break;
  case 6:
   System.out.println("Six geese a-laying");
    break;
  case 7:
   System.out.println("Seven swans a-swimming");
   break;
  case 8:
   System.out.println("Eight maids a making");
     break;
  case 9: 
  System.out.println("Nine ladies dancing");
    break;
  case 10: 
  System.out.println("10 lords a-leaping");
     break;
  case 11:
   System.out.println("11 pipers piping");
  break;
  case 12:
   System.out.println("12 drummers drumming");
  }
  
  System.out.println("Enter a day of Christmas: ");
  dayOfChristmas = scanner.nextInt();

  }


}

}