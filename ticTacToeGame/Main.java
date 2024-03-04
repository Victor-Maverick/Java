package ticTacToeGame;

import java.util.Scanner;

public class Main {
    private static TicTacToe ticTacToe = new TicTacToe();
    private static Player player1 = ticTacToe.getPlayer1();
    private static Player player2 = ticTacToe.getPlayer2();
    private static Scanner scanner = new Scanner(System.in);



    public static void main(String[] args) {
        playGame();
    }

    private static void playGame(){
        ticTacToe.display();
        boolean isWon = ticTacToe.checkForWinner(player1.getCellType()) || ticTacToe.checkForWinner(player1.getCellType());
        while (true){
            try {
                if(isWon)System.exit(0);
                if (ticTacToe.isBoardFull())break;
                System.out.println("Player " + player1.getCellType() + " make a move from 1-9: ");
                int playerOnePosition = scanner.nextInt();
                player1.play(ticTacToe, playerOnePosition);
                ticTacToe.display();
                System.out.println("Player " + player2.getCellType() + " make a move from 1-9: ");
                int playerTwoPosition = scanner.nextInt();
                player2.play(ticTacToe, playerTwoPosition);
                ticTacToe.display();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
