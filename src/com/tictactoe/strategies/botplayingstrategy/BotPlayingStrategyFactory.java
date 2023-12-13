package src.com.tictactoe.strategies.botplayingstrategy;

import src.com.tictactoe.models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyForDificultyLevel(BotDifficultyLevel level){
        return switch (level) {
            case EASY -> new RandomBotPlayingStrategy();
            case MEDIUM -> new RandomBotPlayingStrategy();
            case HARD -> new RandomBotPlayingStrategy();
        };
    }
}
