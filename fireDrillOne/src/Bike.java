public class Bike {
    private boolean isOn;
    private int speed;
    private int gear;
    public boolean isBikeOn() {
        return isOn;
    }

    public void toggle(){
        isOn = !isOn;
    }

    public int getGear(){
        return gear;
    }

    public void changeGear(){
        if (isBikeOn()) {
            if (speed >= 0 && speed <= 20) gear = 1;
            if (speed >= 21 && speed <= 30) gear = 2;
            if (speed >= 31 && speed <= 40) gear = 3;
            if (speed >= 41) gear = 4;
        }
    }

    public void accelerate(){
        if(isBikeOn()) {
            changeGear();
            if (getGear() == 1) speed++;
            if (getGear() == 2) speed += 2;
            if (getGear() == 3) speed += 3;
            if (getGear() == 4) speed += 4;
        }
    }
    public int getSpeed() {
        return speed;
    }

    public void decelerate() {
        if(isBikeOn()) {
            changeGear();
            if (getGear() == 1) speed--;
            if (getGear() == 2) speed -= 2;
            if (getGear() == 3) speed -= 3;
            if (getGear() == 4) speed -= 4;
        }
    }
}
