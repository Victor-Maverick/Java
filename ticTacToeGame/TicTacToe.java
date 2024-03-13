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
                return true;
            }
            if (board[0][row] ==player && board[1][row] == player && board[2][row]==player){
                winner = player;
                return true;
            }
            if (board[0][0] ==player && board[1][1] == player && board[2][2]==player){
                winner = player;
                return true;

            }
            if(board[0][2] ==player && board[1][1] == player && board[2][0]==player){
                winner = player;
                return true;
            }
        }
        return false;
    }

    public void checkBoard(Check playerCell, int position) {
        int row = (position - 1) / 3;
        int column = (position - 1) % 3;
        board[row][column] = playerCell;
        if(checkForWinner(playerCell)){
            display();
            print("Player "+winner+" wins");
            System.exit(0);}
        if(isBoardFull()){
            display();
            print("Draw");
            System.exit(0);
        }

    }

    public boolean isInvalidMove(int position) {
        int row = (position - 1)/3;
        int column = (position - 1)%3;
        if(board[row][column] != EMPTY)throw new InvalidMoveException("Move taken");
        return false;
    }

    public boolean isBoardFull() {
        for (Check[] checks : board) {
            for (Check check : checks)
                if (check == EMPTY) return false;
        }

        return true;
    }


    public void display(){
        print("\n---------------------\n");
        for(int row = 0; row < 3; row++){
            print("| ");
            for (int column = 0; column < 3; column++){
                print(board[row][column]+"| ");
            }
            print("\n---------------------\n");
        }
    }

    public void print(String menu){
        System.out.print(menu);
    }
    public Check[][] getBoard() {
        return board;
    }
}
