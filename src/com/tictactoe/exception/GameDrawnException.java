package src.com.tictactoe.exception;

public class GameDrawnException extends RuntimeException{
    public GameDrawnException(String message) {
        super(message);
    }
}
