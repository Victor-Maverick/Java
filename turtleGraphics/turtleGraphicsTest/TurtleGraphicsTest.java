package turtleGraphicsTest;

import org.junit.jupiter.api.Test;
import turtleGraphics.Direction;
import turtleGraphics.TurtleGraphics;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static turtleGraphics.Direction.*;

public class TurtleGraphicsTest {
    private int[][] board = new int[20][20];

    @Test
    public void penIsUpOnCreationTest(){
        TurtleGraphics turtleGraphics = new TurtleGraphics();
        assertTrue(turtleGraphics.isPenUp());
    }

    @Test
    public void penCanBeDownTest(){
        TurtleGraphics turtleGraphics = new TurtleGraphics();
        assertTrue(turtleGraphics.isPenUp());
        turtleGraphics.penDown();
        assertFalse(turtleGraphics.isPenUp());
    }

    @Test
    public void penIsTurnedUpTest(){
        TurtleGraphics turtleGraphics = new TurtleGraphics();
        assertTrue(turtleGraphics.isPenUp());
        turtleGraphics.penDown();
        assertFalse(turtleGraphics.isPenUp());
        turtleGraphics.penUp();
        assertTrue(turtleGraphics.isPenUp());
    }
    @Test
    public void turtleIsEastOnCreationTest() {
        TurtleGraphics turtleGraphics = new TurtleGraphics();
        assertSame(EAST, turtleGraphics.getDirection());
    }

    @Test
    public void turnLeft_DirectionIsNorthWhenEastTest(){
        TurtleGraphics turtleGraphics = new TurtleGraphics();
        turtleGraphics.turnLeft();
        assertSame(NORTH, turtleGraphics.getDirection());
    }

    @Test
    public void turnLeft_WhenDirectionIsNorth_DirectionTurnsWestTest(){
        TurtleGraphics turtleGraphics = new TurtleGraphics();
        turtleGraphics.turnLeft();
        turtleGraphics.turnLeft();
        assertSame(WEST, turtleGraphics.getDirection());
    }

    @Test
    public void turnLeft_WhenDirectionIsWest_DirectionTurnsSouthTest(){
        TurtleGraphics turtleGraphics = new TurtleGraphics();
        turtleGraphics.turnLeft();
        turtleGraphics.turnLeft();
        turtleGraphics.turnLeft();
        assertSame(SOUTH, turtleGraphics.getDirection());
    }

    @Test
    public void turnLeft_WhenDirectionIsSouth_DirectionTurnsEastTest(){
        TurtleGraphics turtleGraphics = new TurtleGraphics();
        turtleGraphics.turnLeft();
        turtleGraphics.turnLeft();
        turtleGraphics.turnLeft();
        turtleGraphics.turnLeft();
        assertSame(EAST, turtleGraphics.getDirection());
    }

    @Test
    public void turnRight_DirectionIsSouthWhenEastTest(){
        TurtleGraphics turtleGraphics = new TurtleGraphics();
        turtleGraphics.turnRight();
        assertSame(SOUTH, turtleGraphics.getDirection());
    }

    @Test
    public void turnRight_DirectionIsWestWhenSouthTest(){
        TurtleGraphics turtleGraphics = new TurtleGraphics();
        turtleGraphics.turnRight();
        turtleGraphics.turnRight();
        assertSame(WEST, turtleGraphics.getDirection());
    }

    @Test
    public void turnRight_DirectionIsNorthWhenWestTest(){
        TurtleGraphics turtleGraphics = new TurtleGraphics();
        turtleGraphics.turnRight();
        turtleGraphics.turnRight();
        turtleGraphics.turnRight();
        assertSame(NORTH, turtleGraphics.getDirection());
    }

    @Test
    public void turnRight_DirectionIsEastWhenNorthTest(){
        TurtleGraphics turtleGraphics = new TurtleGraphics();
        turtleGraphics.turnRight();
        turtleGraphics.turnRight();
        turtleGraphics.turnRight();
        turtleGraphics.turnRight();
        assertSame(EAST, turtleGraphics.getDirection());
    }

    @Test
    public void boardIsFilledWithZeroOnCreationTest(){
        TurtleGraphics turtleGraphics = new TurtleGraphics();
        for(int[] array : board){
        Arrays.fill(array, 0);
        }
        assertArrayEquals(board, turtleGraphics.getBoard());
    }

    

}
