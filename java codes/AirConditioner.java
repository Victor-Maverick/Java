import java.util.Scanner;
public class AirConditioner{
	private String name;
	private String model;
	private String colour;
	private int temperature = 16;
	private boolean isPowerOn;

	

	public boolean isPowerOn(){
	  return isPowerOn;
	}

	public void powerOn(){
	 if (!isPowerOn){
	   isPowerOn = true;
	    System.out.printf("%s %s  POWER ON%n16%n", getName(), getModel());
	  }else{
		System.out.print("power is off");
	    }
	}

	public void powerOff(){
	if (isPowerOn){
	   isPowerOn = false;
	    System.out.printf("%s %s%n%d%n--%nPOWER OFF%n  ", getName(), getModel(), getTemperature());
	  }else{
	     System.out.print("power is off");
	    }
	}

	public int increaseTemperature(){
	  if (isPowerOn) {
	   temperature++;
	System.out.println("Temperature is increasing");
	  if (temperature >= 32){
            temperature = 32;
           }
	  }
 return temperature;
	}

	public int decreaseTemperature(){
	  if (isPowerOn){
           temperature--;
System.out.println("Temperature is decreasing");
	   if (temperature <= 16){
            temperature = 16;

           }
	
	  }
return temperature;
	}

         Scanner sc = new Scanner(System.in);
        public int increaseTemperature(int temp){
	  if (isPowerOn) {
	   System.out.println("How many degrees do you want to increase the temperature");
           temp = sc.nextInt();
	   if (temp + temperature > 32){
            temperature = 32;
            System.out.println("max");
           }
	   else{
	System.out.printf("Temperature increase by %d%n", temp);
         temperature += temp;
	  }
	  }
 return temperature;
	}

	public int decreaseTemperature(int tempDecrease){
	  if (isPowerOn){
           System.out.println("how many degrees do you want to decrease the temperature: ");
           tempDecrease = sc.nextInt();
System.out.printf("Temperature decrease by %d%n", tempDecrease);
	   temperature -= tempDecrease;
	   if (temperature <= 16){
            temperature = 16;

           }
	
	  }
return temperature;
	}







	public int getTemperature(){
	System.out.printf("The temperature is %d", temperature);

	  return temperature;
	}

	public void setName(String name){
	  this.name = name;
	}

	public String getName(){
	 System.out.print(name); 
	 return name;
	}

	public void setModel(String model){
	  this.model = model;
	}

	public String getModel(){
	  System.out.print(model); 
	 return model;
	}

	public void setColour(String colour){
	  this.colour = colour;
	}

	public String getColour(){
	  System.out.print(colour); 
	 return colour;
	}

}