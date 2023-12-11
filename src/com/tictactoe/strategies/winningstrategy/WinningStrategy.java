package src.com.tictactoe.strategies.winningstrategy;

import src.com.tictactoe.models.Board;
import src.com.tictactoe.models.Move;
import src.com.tictactoe.models.Player;

public interface WinningStrategy {
    /*
    0,0  0,1  0,2
    1,0  1,1  1,2
    2,0  2,1  2,2

    row-> 0 || dim-1
    col-> 0 || dim-1

     */

    Player checkWinner(Board board, Move lastMove);
}
