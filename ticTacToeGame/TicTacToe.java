package ticTacToeGame;

import java.util.Arrays;

import static ticTacToeGame.Check.*;

public class TicTacToe {
    private final Check[][] board;

    Check winner = null;
    Player player1 = new Player(1, X);
    Player player2 = new Player(2, O);

    public TicTacToe(){
        board = new Check[3][3];
        for (Check[] checks : board) Arrays.fill(checks, EMPTY);
    }

    public Player getPlayer1(){
        return player1;
    }

    public Player getPlayer2(){
        return player2;
    }

    public void makeMove(Check playerCell, int position) {
        if(position < 1 || position >9)throw new MoveOutOfRangeException("wrong move");
        checkBoard(playerCell, position);
    }

    public boolean checkForWinner(Check player) {
        for (int row = 0; row < 3; row++){
            if (board[row][0] ==player && board[row][1] == player && board[row][2]==player){
                winner = player;
                System.out.println("Player "+ winner + " wins");
                return true;
            }
            if (board[0][row] ==player && board[1][row] == player && board[2][row]==player){
                winner = player;
                System.out.println("Player "+ winner + " wins");
                return true;
            }
            if (board[0][0] ==player && board[1][1] == player && board[2][2]==player){
                winner = player;
                System.out.println("Player "+ winner + " wins");
                return true;
            }
            if(board[0][2] ==player && board[1][1] == player && board[2][0]==player){
                winner = player;
                System.out.println("Player "+ winner + " wins");
                return true;
            }
        }
        return false;
    }

    public void checkBoard(Check playerCell, int position) {
        int row = (position-1) / 3;
        int column = (position - 1) % 3;
        board[row][column] = playerCell;
        if(checkForWinner(playerCell))System.exit(0);
        if(isBoardFull())System.exit(0);

    }

    public boolean isBoardFull() {
        for (Check[] checks : board) {
            for (Check check : checks)
                if (check == EMPTY) return false;
        }
        System.out.println("Draw");
        return true;
    }


    public void display(){
        System.out.println("\n---------------------");
        for(int row = 0; row < 3; row++){
            System.out.print("| ");
            for (int column = 0; column < 3; column++){
                System.out.print(board[row][column]+"| ");
            }
            System.out.println("\n---------------------");
        }
    }

    public Check[][] getBoard() {
        return board;
    }
}
