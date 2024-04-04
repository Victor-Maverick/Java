package turtleGame;


import turtleGame.exceptions.InvalidMoveException;

import static turtleGame.Direction.EAST;

public class Turtle {
    private Direction currentDirection = EAST;
    private Position currentPosition = new Position(0, 0);
    private boolean isPenUp = true;


    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void turnLeft() {
        currentDirection = currentDirection.turnLeft();
    }

    public void turnRight(){
        currentDirection = currentDirection.turnRight();
    }

    public boolean isPenUp() {
        return isPenUp;
    }

    public void penDown() {
        isPenUp = false;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }


    public void moveForward(int numberOfSteps, Sketchpad sketchpad) {
        if (numberOfSteps < 1)throw new InvalidMoveException("Move should be positive");
        if (!isPenUp)writeOn(sketchpad, numberOfSteps);
        switch (currentDirection){
            case EAST -> moveForwardEastWard(numberOfSteps);
            case SOUTH -> moveForwardSouthWard(numberOfSteps);
            case NORTH -> moveForwardNorthWard(numberOfSteps);
            case WEST -> moveForwardWestWard(numberOfSteps);
        }
    }

    private void moveForwardWestWard(int numberOfSteps) {
        for (int count = 1; count <= numberOfSteps; count++)
            currentPosition.setColumn(currentPosition.getColumn() - 1);
    }

    private void moveForwardNorthWard(int numberOfSteps) {
        for (int count = 1; count <= numberOfSteps; count++)
            currentPosition.setRow(currentPosition.getRow() - 1);
    }

    private void moveForwardSouthWard(int numberOfSteps) {
        currentPosition.setRow(currentPosition.getRow() + numberOfSteps - 1);
    }

    private void writeOn(Sketchpad sketchpad, int numberOfSteps) {
        switch (currentDirection){
            case EAST -> writeEastWardOn(sketchpad,numberOfSteps);
            case SOUTH -> writeSouthWardOn(sketchpad,numberOfSteps);
            case NORTH -> writeNorthWardOn(sketchpad, numberOfSteps);
            case WEST -> writeWestWardOn(sketchpad, numberOfSteps);
        }
    }

    private void writeWestWardOn(Sketchpad sketchpad, int numberOfSteps) {
        int column = currentPosition.getColumn();
        for (int count = 0; count < numberOfSteps; count++){
            sketchpad.getFloor()[currentPosition.getRow()][column] = 1;
            column --;
        }
    }

    private void writeNorthWardOn(Sketchpad sketchpad, int numberOfSteps) {
        int row = getCurrentPosition().getRow();
        for (int count = 1; count <= numberOfSteps; count++) {
            sketchpad.getFloor()[row][currentPosition.getColumn()] = 1;
            row--;
        }
    }

    private void writeSouthWardOn(Sketchpad sketchpad, int numberOfSteps) {
        for (int count = 0; count < numberOfSteps; count++)
            sketchpad.getFloor()[count][currentPosition.getColumn()] = 1;

    }

    private void writeEastWardOn(Sketchpad sketchpad, int numberOfSteps) {
        for (int count = 0; count < numberOfSteps; count++)
            sketchpad.getFloor()[currentPosition.getRow()][count] = 1;

    }

    private void moveForwardEastWard(int numberOfSteps) {
        currentPosition.setColumn(currentPosition.getColumn() + numberOfSteps -1);
    }
}
