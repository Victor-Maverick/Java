package mindfort;

public class Cylinder {
    private int radius = 1;
    private int height = 1;

    public double getRadius() {
        return radius;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if(height > 0) {
            this.height = height;
        }
    }

    public void setRadius(int radius) {
        if(radius > 0) {
            this.radius = radius;
        }
    }
}
