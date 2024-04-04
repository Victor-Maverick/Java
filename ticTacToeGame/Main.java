package ticTacToeGame;

import java.util.Scanner;



public class Main {
    private static final TicTacToe ticTacToe = new TicTacToe();
    private static Player player1 = ticTacToe.getPlayer1();
    private static Player player2 = ticTacToe.getPlayer2();
    private static Scanner scanner = new Scanner(System.in);



    public static void main(String[] args) {
        playGame();
    }

    private static void playGame(){
        ticTacToe.display();
        boolean isWon = false;
        while (!isWon){
            try {
                if (ticTacToe.checkForWinner(player1.getCellType()) || ticTacToe.checkForWinner(player1.getCellType())) isWon = true;

                int playerOnePosition = getPlayerOnePosition();
                while (ticTacToe.isInvalidMove(playerOnePosition))playerOnePosition = getPlayerOnePosition();
                player1.play(ticTacToe, playerOnePosition);
                ticTacToe.display();
                int playerTwoPosition = getPlayerTwoPosition();
                while (ticTacToe.isInvalidMove(playerTwoPosition))playerTwoPosition = getPlayerTwoPosition();
                player2.play(ticTacToe, playerTwoPosition);
                ticTacToe.display();
            }
            catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static int getPlayerTwoPosition() {
        print("Player " + player2.getCellType() + " make a move from 1-9: ");
        return scanner.nextInt();
    }

    private static int getPlayerOnePosition() {
        print("Player " + player1.getCellType() + " make a move from 1-9: ");
        return scanner.nextInt();
    }

    private static void print(String menu) {
        System.out.println(menu);
    }
}
