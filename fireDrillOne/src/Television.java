public class Television {
    private boolean isTvOn;
    private int volume;
    private int channel = 1;
    public boolean isTvOn() {
        return isTvOn;
    }

    public void toggle() {
        isTvOn = !isTvOn;
    }

    public int getVolume() {
            return volume;
    }

    public void increaseVolume() {
        if(isTvOn()) {
            if(volume >= 0 && volume < 10)volume++;
        }
    }

    public void decreaseVolume() {
        if(isTvOn()) {
            if(volume > 0 && volume <= 10) volume--;
        }
    }

    public int getChannel() {
        return channel;
    }

    public void increaseChannel() {
        if(isTvOn()) {
            channel ++;
            if(channel == 11) channel = 1;
        }
    }

    public void decreaseChannel() {
        if(isTvOn()) {
            channel--;
            if(channel == 0) channel = 10;
        }
    }
}
