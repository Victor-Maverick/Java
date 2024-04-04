package ticTacToeGame;

public class Player {
    private int id;
    private Check cellType;


    public Check getCellType() {
        return cellType;
    }

    public Player(int id, Check cellType){
        this.id = id;
        this.cellType = cellType;
    }

    public void play(TicTacToe ticTacToe, int position){
        ticTacToe.makeMove(this.cellType, position);
    }

    public int getId() {
        return id;
    }
}
