package turtleGraphics;

import java.util.Arrays;

import static turtleGraphics.Direction.*;

public class TurtleGraphics {
    private Direction direction = EAST;
    private  boolean isPenUp = true;
    private int[][] board = new int[20][20];

    public TurtleGraphics(){
        for (int[] array : board){
            Arrays.fill(array, 0);
        }
    }
    public Direction getDirection() {
        return direction;
    }

    public boolean isPenUp() {
        return isPenUp;
    }

    public void penDown() {
        isPenUp = false;
    }

    public void penUp() {
        isPenUp = true;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public int[][] getBoard() {
        return board;
    }
}
