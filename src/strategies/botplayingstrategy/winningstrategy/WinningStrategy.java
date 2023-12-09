package src.strategies.botplayingstrategy.winningstrategy;

import src.models.Board;
import src.models.Player;

public interface WinningStrategy {
    Player checkWinner(Board board);
}
