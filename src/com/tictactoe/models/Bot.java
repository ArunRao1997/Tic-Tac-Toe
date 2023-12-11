package src.com.tictactoe.models;

import src.com.tictactoe.strategies.botplayingstrategy.BotPlayingStrategy;

public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(Symbol symbol, String name, BotDifficultyLevel botDifficultyLevel, BotPlayingStrategy botPlayingStrategy) {
        super(symbol, name, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = botPlayingStrategy;
    }

    public Move makeMove(Board board) {
        Move move = botPlayingStrategy.makeMove(this, board); // move cell
        move.setPlayer(this); // move player
        return move;
    }

    public BotDifficultyLevel botDifficultyLevel() {
        return botDifficultyLevel;
    }

    public Bot setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
        return this;
    }

    public BotPlayingStrategy botPlayingStrategy() {
        return botPlayingStrategy;
    }

    public Bot setBotPlayingStrategy(BotPlayingStrategy botPlayingStrategy) {
        this.botPlayingStrategy = botPlayingStrategy;
        return this;
    }
}
