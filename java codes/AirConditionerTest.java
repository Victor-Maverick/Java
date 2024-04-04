import java.util.Scanner;
  public class AirConditionerTest{

  public static void main(String[] args){

  Scanner input = new Scanner(System.in);

  AirConditioner ac = new AirConditioner();

  String model = "Samsung";
  ac.setModel(model);

  String name = "Life";
  ac.setName(name);

  String colour = "White";
  ac.setColour(colour);
  
  ac.getName();
  ac.getModel();
  ac.powerOn();
  ac.decreaseTemperature(10);

System.out.printf("The temperature is %d%n", ac.getTemperature());


  ac.decreaseTemperature();
  ac.getTemperature();

ac.increaseTemperature(12);
ac.getTemperature();

ac.increaseTemperature();
ac.getTemperature();

  ac.powerOff();

 


  }









}