public class Time1Test{

  public static void main(String[] args){
  Time1 time = new Time1();

  displayTime("After time object is created", time);
  System.out.println();

  time.setTime(14, 43, 4);
  displayTime("After setting the time", time);
  System.out.println();
  
    try{
      time.setTime(95,77,83);
    }
    catch(IllegalArgumentException e){
      System.out.printf("Exception: %s%n%n", e.getMessage());
    }

  displayTime("Updated time: ", time);
  }
  private static void displayTime(String header, Time1 t){
  System.out.printf("%s%nUniversal time: %s%nStandard time: %s%n", header, t.toUniversalString(), t.toString());
  }
}