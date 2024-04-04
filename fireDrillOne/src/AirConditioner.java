public class AirConditioner{
    private boolean isOn;
    private int temperature = 16;

    public boolean isPowerOn(){return isOn;}

    public int getTemperature(){return temperature;}

    public void toggle(){
        isOn = !isOn;
    }


    public void increaseTemperature(){
        boolean temperatureWithinRange = temperature >= 16 && temperature < 30;
        if(isPowerOn() && temperatureWithinRange)
            temperature++;
    }

    public void decreaseTemperature() {

        boolean temperatureWithinRange = temperature > 16 && temperature <= 30;
        if (isPowerOn() && temperatureWithinRange){
            temperature --;
        }
    }


}
