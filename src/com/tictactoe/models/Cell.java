package src.com.tictactoe.models;

public class Cell {
    private int row;
    private int col;
    private CellState cellState;
    private Player player;

    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        this.cellState = CellState.EMPTY;
    }

    public Cell(int row, int col, Player player) {
        this.row = row;
        this.col = col;
        this.player = player;
        this.cellState = CellState.FILLED;
    }


    public Cell(int row, int col, CellState cellState, Player player) {
        this.row = row;
        this.col = col;
        this.cellState = cellState;
        this.player = player;
    }

    public void display() {
        if (player == null) {
            System.out.print("| |");
        }else if(cellState.equals(CellState.BLOCKED)){
            System.out.println("||||");
        }
        else {
            System.out.print("|"+ player.symbol().symbolChar() + "|");
        }
    }

    public int row() {
        return row;
    }

    public Cell setRow(int row) {
        this.row = row;
        return this;
    }

    public int col() {
        return col;
    }

    public Cell setCol(int col) {
        this.col = col;
        return this;
    }

    public CellState cellState() {
        return cellState;
    }

    public Cell setCellState(CellState cellState) {
        this.cellState = cellState;
        return this;
    }

    public Player player() {
        return player;
    }

    public Cell setPlayer(Player player) {
        this.player = player;
        return this;
    }
}
