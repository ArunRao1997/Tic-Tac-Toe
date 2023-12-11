package src.com.tictactoe.strategies.winningstrategy;

import src.com.tictactoe.models.Board;
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

    public boolean isCornerCell(int row, int col){
        // 0,0 || 0,dim-1 || dim-1,0 || dim-1, dim-1
        if(row == 0 || row == dimension-1){
            return col == 0 || col == dimension-1;
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
    public Player checkWinner(Board board) {
        return null;
    }
}
