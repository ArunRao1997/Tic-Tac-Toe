package src.com.tictactoe.exception;

public class InvalidNumberOfPlayersException extends RuntimeException{
    public InvalidNumberOfPlayersException(String message) {
        super(message);
    }
}
