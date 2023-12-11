package src.com.tictactoe.models;

import java.util.Scanner;

public class Player {
    private static int idCounter = 0;
    private int id;
    private Symbol symbol;
    private String name;
    private PlayerType playerType;
    private Scanner scanner;

    public Player(Symbol symbol, String name, PlayerType playerType) {
        this.id = idCounter++;
        this.symbol = symbol;
        this.name = name;
        this.playerType = playerType;
        this.scanner = new Scanner(System.in);
    }

    public Move makeMove(Board board) {
        System.out.println("Please enter the row for the move");
        int row = scanner.nextInt();
        System.out.println("Please enter the column for the move");
        int col = scanner.nextInt();

        // TO DO: validate the move or throw exception

        // Cell cell = new Cell(row, col, this);
        // return new Move(cell, this);

        board.board().get(row).get(col).setPlayer(this);
        return new Move(new Cell(row, col, this), this);

    }

    public int id() {
        return id;
    }

    public Player setId(int id) {
        this.id = id;
        return this;
    }

    public Symbol symbol() {
        return symbol;
    }

    public Player setSymbol(Symbol symbol) {
        this.symbol = symbol;
        return this;
    }

    public String name() {
        return name;
    }

    public Player setName(String name) {
        this.name = name;
        return this;
    }

    public PlayerType playerType() {
        return playerType;
    }

    public Player setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
        return this;
    }

    public Scanner scanner() {
        return scanner;
    }

    public Player setScanner(Scanner scanner) {
        this.scanner = scanner;
        return this;
    }
}
