package src.strategies.botplayingstrategy;

import src.models.Board;
import src.models.Move;

public interface BotPlayingStrategy {
    Move makeMove(Board board);
}
