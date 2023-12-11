package src.com.tictactoe.strategies.botplayingstrategy;

import src.com.tictactoe.models.Board;
import src.com.tictactoe.models.Move;

public interface BotPlayingStrategy {
    Move makeMove(Board board);
}
