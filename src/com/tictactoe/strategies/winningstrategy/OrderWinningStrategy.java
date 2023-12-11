package src.com.tictactoe.strategies.winningstrategy;

import src.com.tictactoe.models.Board;
import src.com.tictactoe.models.Move;
import src.com.tictactoe.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderWinningStrategy implements WinningStrategy {

    private int dimension;
    private List<HashMap<Character, Integer>> rowSymbolCount = new ArrayList<>(); // []
    private List<HashMap<Character, Integer>> colSymbolCount = new ArrayList<>(); // []
    private HashMap<Character, Integer> topLeftDiagonalSymbolCount = new HashMap<>();
    private HashMap<Character, Integer> bottomLeftDiagonalSymbolCount = new HashMap<>();
    private HashMap<Character, Integer> cornerSymbolCount = new HashMap<>();

    public OrderWinningStrategy(int dimension) {
        this.dimension = dimension;
        for (int i = 0; i < dimension; i++) {
            rowSymbolCount.add(new HashMap<>());
            colSymbolCount.add(new HashMap<>());
        }
        // rowSymbolCount List = [{}, {}, {}]
    }

    public boolean isCellTopLeftDiagonal(int row, int col) {
        return row == col;
    }

    public boolean isCellBottomLeftDiagonal(int row, int col) {
        return (row + col) == dimension - 1;
    }

    public boolean isCornerCell(int row, int col) {
        // 0,0 || 0,dim-1 || dim-1,0 || dim-1, dim-1
        if (row == 0 || row == dimension - 1) {
            return col == 0 || col == dimension - 1;
        }
        return false;
    }

    /*
    0,0  0,1  0,2
    1,0  1,1  1,2
    2,0  2,1  2,2

    row-> 0 || dim-1
    col-> 0 || dim-1

     */
    @Override
    public Player checkWinner(Board board, Move lastMove) {
        Player lastMovePlayer = lastMove.player();
        char symbol = lastMove.player().symbol().symbolChar();
        int row = lastMove.cell().row();
        int col = lastMove.cell().col();
        int dimension = board.size();
        if (checkForRowWins(row, col, symbol, lastMove) != null)
            return lastMovePlayer;
        else if (checkForColumnWins(row, col, symbol, lastMove) != null)
            return lastMovePlayer;
        else if (checkForDiagonalWins(row, col, symbol, lastMove) != null)
            return lastMovePlayer;
        else if (checkForCornerWins(row, col, symbol, lastMove) != null)
            return lastMovePlayer;
        return null;
    }


    private Player checkForDiagonalWins(int row, int col, char symbol, Move lastMove) {
         /*
        Check for diagonal hashmaps
         */
        if (isCellTopLeftDiagonal(row, col)) {
            if (!topLeftDiagonalSymbolCount.containsKey(symbol)) {
                topLeftDiagonalSymbolCount.put(symbol, 0);
            }
            topLeftDiagonalSymbolCount.put(
                    symbol, // key
                    topLeftDiagonalSymbolCount.get(symbol) + 1 // value
            );
            // winning by same symbol across the diagonal
            if (topLeftDiagonalSymbolCount.get(symbol) == dimension)
                return lastMove.player();
        }

        if (isCellBottomLeftDiagonal(row, col)) {
            if (!bottomLeftDiagonalSymbolCount.containsKey(symbol)) {
                bottomLeftDiagonalSymbolCount.put(symbol, 0);
            }
            bottomLeftDiagonalSymbolCount.put(
                    symbol, // key
                    bottomLeftDiagonalSymbolCount.get(symbol) + 1 // value
            );
            // winning by same symbol across the diagonal
            if (bottomLeftDiagonalSymbolCount.get(symbol) == dimension)
                return lastMove.player();
        }
        return null;
    }

    private Player checkForCornerWins(int row, int col, char symbol, Move lastMove) {
         /*
        Check for the corners
         */
        if (isCornerCell(row, col)) {
            if (!cornerSymbolCount.containsKey(symbol)) {
                cornerSymbolCount.put(symbol, 0);
            }
            cornerSymbolCount.put(
                    symbol, // key
                    cornerSymbolCount.get(symbol) + 1 // value
            );
            // winning by same symbol across the diagonal
            if (cornerSymbolCount.get(symbol) == dimension)
                return lastMove.player();
        }
        return null;
    }

    private Player checkForRowWins(int row, int col, char symbol, Move lastMove) {
        /*
        Logic for row hashmap update and count
         */
        if (!rowSymbolCount.get(row).containsKey(symbol)) {
            rowSymbolCount.get(row).put(symbol, 0);
        }
        rowSymbolCount.get(row).put(
                symbol, // key
                rowSymbolCount.get(row).get(symbol) + 1 // value
        );
        // winning by same symbol across the row
        if (rowSymbolCount.get(row).get(symbol) == dimension)
            return lastMove.player();
        return null;
    }

    private Player checkForColumnWins(int row, int col, char symbol, Move lastMove) {
        /*
        Logic for column hashmap update and count
         */
        if (!colSymbolCount.get(col).containsKey(symbol)) {
            colSymbolCount.get(col).put(symbol, 0);
        }
        colSymbolCount.get(col).put(
                symbol, // key
                colSymbolCount.get(col).get(symbol) + 1 // value
        );
        // winning by same symbol across the col
        if (colSymbolCount.get(col).get(symbol) == dimension)
            return lastMove.player();
        return null;
    }
}
