package src.exception;

public class InvalidNumberOfPlayersException extends RuntimeException{
    public InvalidNumberOfPlayersException(String message) {
        super(message);
    }
}
