package turtleTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import turtleGame.Position;
import turtleGame.Sketchpad;
import turtleGame.Turtle;
import turtleGame.exceptions.InvalidMoveException;

import static org.junit.jupiter.api.Assertions.*;
import static turtleGame.Direction.*;


public class TurtleTest {
    private Turtle turtle;
    private Sketchpad sketchpad;

    @BeforeEach
    public void setup(){
        turtle = new Turtle();
        sketchpad = new Sketchpad(20, 20);
    }

    @Test
    public void penIsUpOnCreationTest(){
        assertTrue(turtle.isPenUp());
    }

    @Test
    public void penCanBeDownTest(){
        assertTrue(turtle.isPenUp());
        turtle.penDown();
        assertFalse(turtle.isPenUp());
    }
    @Test
    public void turtleLocationIsEastOnCreationTest(){
        assertEquals(EAST, turtle.getCurrentDirection());
    }

    @Test
    public void turnLeftWhenTurtleIsEast_DirectionIsNorthTest(){
        turtle.turnLeft();
        assertEquals(NORTH, turtle.getCurrentDirection());
    }

    @Test
    public void turnLeft_WhenDirectionIsWest_DirectionTurnsSouthTest(){
        turtle.turnLeft();
        turtle.turnLeft();
        turtle.turnLeft();
        assertEquals(SOUTH, turtle.getCurrentDirection());
    }

    @Test
    public void turnLeft_WhenDirectionIsSouth_DirectionTurnsEastTest(){
        turtle.turnLeft();
        turtle.turnLeft();
        turtle.turnLeft();
        turtle.turnLeft();
        assertSame(EAST, turtle.getCurrentDirection());
    }

    @Test
    public void turnRight_DirectionIsSouthWhenEastTest(){
        turtle.turnRight();
        assertSame(SOUTH, turtle.getCurrentDirection());
    }

    @Test
    public void turnRight_DirectionIsWestWhenSouthTest(){
        turtle.turnRight();
        turtle.turnRight();
        assertSame(WEST, turtle.getCurrentDirection());
    }

    @Test
    public void turnRight_DirectionIsNorthWhenWestTest(){
        turtle.turnRight();
        turtle.turnRight();
        turtle.turnRight();
        assertSame(NORTH, turtle.getCurrentDirection());
    }

    @Test
    public void turnRight_DirectionIsEastWhenNorthTest(){
        turtle.turnRight();
        turtle.turnRight();
        turtle.turnRight();
        turtle.turnRight();
        assertSame(EAST, turtle.getCurrentDirection());
    }

    @Test
    public void turtleCanMoveForwardEastwardOnSketchPadTest(){
        assertEquals(EAST, turtle.getCurrentDirection());
        assertEquals(turtle.getCurrentPosition(), new Position(0,0));
        turtle.moveForward(5, sketchpad);
        assertEquals(turtle.getCurrentPosition(), new Position(0, 4));
    }

    @Test
    public void turtleCanWriteOnSketchpadEastwardTest(){
        assertEquals(EAST, turtle.getCurrentDirection());
        assertEquals(turtle.getCurrentPosition(), new Position(0,0));
        turtle.penDown();
        turtle.moveForward(5, sketchpad);
        assertEquals(turtle.getCurrentPosition(), new Position(0, 4));
        int[][] floor = sketchpad.getFloor();
        assertEquals(floor[0][0], 1);
        assertEquals(floor[0][1], 1);
        assertEquals(floor[0][2], 1);
        assertEquals(floor[0][3], 1);
        assertEquals(floor[0][4], 1);
    }

    @Test
    public void turtleCanMoveForwardSouthwardOnSketchPadTest(){
        assertEquals(EAST, turtle.getCurrentDirection());
        assertEquals(turtle.getCurrentPosition(), new Position(0,0));
        turtle.turnRight();
        turtle.moveForward(5, sketchpad);
        assertEquals(turtle.getCurrentPosition(), new Position(4, 0));
    }
    @Test
    public void turtleCanWriteOnSketchpadSouthwardTest(){
        assertEquals(EAST, turtle.getCurrentDirection());
        assertEquals(turtle.getCurrentPosition(), new Position(0,0));
        turtle.turnRight();
        turtle.penDown();
        turtle.moveForward(5, sketchpad);
        assertEquals(turtle.getCurrentPosition(), new Position(4, 0));
        int[][] floor = sketchpad.getFloor();
        assertEquals(floor[0][0], 1);
        assertEquals(floor[1][0], 1);
        assertEquals(floor[2][0], 1);
        assertEquals(floor[3][0], 1);
        assertEquals(floor[4][0], 1);
    }

    @Test
    public void turtleCanMoveForwardNorthwardOnSketchPadTest(){
        assertEquals(EAST, turtle.getCurrentDirection());
        assertEquals(turtle.getCurrentPosition(), new Position(0,0));
        turtle.turnRight();
        turtle.moveForward(5, sketchpad);
        assertEquals(turtle.getCurrentPosition(), new Position(4, 0));
        turtle.turnLeft();
        turtle.turnLeft();
        turtle.moveForward(3, sketchpad);
        assertEquals(turtle.getCurrentPosition(), new Position(1, 0));
    }

    @Test
    public void turtleCanWriteOnSketchpadNorthwardTest(){
        assertEquals(EAST, turtle.getCurrentDirection());
        assertEquals(turtle.getCurrentPosition(), new Position(0,0));
        turtle.turnRight();
        turtle.moveForward(5, sketchpad);
        assertEquals(turtle.getCurrentPosition(), new Position(4, 0));
        turtle.turnLeft();
        turtle.turnLeft();
        turtle.penDown();
        turtle.moveForward(3, sketchpad);
        int[][] floor = sketchpad.getFloor();
        assertEquals(floor[2][0], 1);
        assertEquals(floor[3][0], 1);
        assertEquals(floor[4][0], 1);

    }
    @Test
    public void turtleCanMoveForwardWestWardOnSketchPadTest(){
        assertEquals(EAST, turtle.getCurrentDirection());
        assertEquals(turtle.getCurrentPosition(), new Position(0,0));
        turtle.moveForward(5, sketchpad);
        turtle.turnLeft();
        turtle.turnLeft();
        turtle.moveForward(2, sketchpad);
        assertEquals(turtle.getCurrentPosition(), new Position(0,2));
    }

    @Test
    public void turtleCanWriteWestWardOnSketchpadTest(){
        assertEquals(EAST, turtle.getCurrentDirection());
        assertEquals(turtle.getCurrentPosition(), new Position(0,0));
        turtle.moveForward(5, sketchpad);
        turtle.turnLeft();
        turtle.turnLeft();
        turtle.penDown();
        turtle.moveForward(3, sketchpad);
        int[][] floor = sketchpad.getFloor();
        assertEquals(floor[0][2], 1);
        assertEquals(floor[0][3], 1);
        assertEquals(floor[0][4], 1);
    }

    @Test
    public void moveForwardWithNegativeMove_throwsExceptionTest(){
        assertEquals(EAST, turtle.getCurrentDirection());
        assertEquals(turtle.getCurrentPosition(), new Position(0,0));
        assertThrows(InvalidMoveException.class, ()->turtle.moveForward(-5, sketchpad));
        assertEquals(turtle.getCurrentPosition(), new Position(0,0));
    }

}
