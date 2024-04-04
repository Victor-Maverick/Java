package turtleGame;

public class Sketchpad {
    private int[][] floor;

    public Sketchpad(int floorRow, int floorColumn) {
        floor = new int[floorRow][floorColumn];
    }

    public int[][] getFloor() {
        return floor;
    }
}
