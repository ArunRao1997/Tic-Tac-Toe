package src.com.tictactoe.strategies.winningstrategy;

public class WinningStrategyFactory {
    public static WinningStrategy getWinningStrategy(int dimension){
        return new OrderWinningStrategy(dimension);
    }
    //TODO: basis of input, return a list of winning strategies
}
