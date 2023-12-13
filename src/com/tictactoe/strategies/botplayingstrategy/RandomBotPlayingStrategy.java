package src.com.tictactoe.strategies.botplayingstrategy;

import src.com.tictactoe.models.*;
import src.com.tictactoe.strategies.botplayingstrategy.BotPlayingStrategy;

public class RandomBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move makeMove(Player player, Board board) {
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.size(); j++) {
                if (board.board().get(i).get(j).cellState().equals(CellState.EMPTY)){
                    board.board().get(i).get(j).setPlayer(player);
                    board.board().get(i).get(j).setCellState(CellState.FILLED);
                    return new Move(new Cell(i, j), player);
                }
            }
        }
        return null;
    }
}
