package ticTacToeGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;
import static ticTacToeGame.Check.EMPTY;

public class TicTacToeTest {
    private TicTacToe ticTacToe;
    Check[][] checks = {{EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, EMPTY}};

    @BeforeEach
    public void beginAllWith(){
        ticTacToe = new TicTacToe();
    }

    @Test
    public void gameHasBoardToPlayTest(){
        assertArrayEquals(checks, ticTacToe.getBoard());
    }

    @Test
    public void playersMarkBoardDifferentlyTest(){
        ticTacToe.player1.play(ticTacToe, 1);
        assertEquals(ticTacToe.getBoard()[0][0], Check.X);
        ticTacToe.player2.play(ticTacToe, 3);
        assertEquals(ticTacToe.getBoard()[0][2], Check.O);
    }

    @Test
    public void makeMoveBelowOrBeyondRangeThrowsExceptionTest(){
        assertThrows(MoveOutOfRangeException.class, ()-> ticTacToe.player1.play(ticTacToe, 0));
        assertThrows(MoveOutOfRangeException.class, ()-> ticTacToe.player1.play(ticTacToe, 10));
    }
    @Test
    public void player1CanWinAcrossRow1(){
        ticTacToe.player1.play(ticTacToe, 1);
        ticTacToe.player2.play(ticTacToe, 5);
        ticTacToe.player1.play(ticTacToe, 2);
        ticTacToe.player1.play(ticTacToe, 3);
        assertTrue(ticTacToe.checkForWinner(Check.X));
    }

}
