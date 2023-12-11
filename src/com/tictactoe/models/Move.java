package src.com.tictactoe.models;

public class Move {
    private Cell cell;
    private Player player;

    public Move(Cell cell, Player player) {
        this.cell = cell;
        this.player = player;
    }

    public Cell cell() {
        return cell;
    }

    public Move setCell(Cell cell) {
        this.cell = cell;
        return this;
    }

    public Player player() {
        return player;
    }

    public Move setPlayer(Player player) {
        this.player = player;
        return this;
    }
}
