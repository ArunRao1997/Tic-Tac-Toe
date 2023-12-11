package src.com.tictactoe.strategies.botplayingstrategy;

import src.com.tictactoe.models.Board;
import src.com.tictactoe.models.Move;
import src.com.tictactoe.models.Player;

public interface BotPlayingStrategy {
    Move makeMove(Player player, Board board);
}
