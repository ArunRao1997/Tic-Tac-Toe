package src.com.tictactoe.strategies.winningstrategy;

import src.com.tictactoe.models.Board;
import src.com.tictactoe.models.Player;

public interface WinningStrategy {
    Player checkWinner(Board board);
}
