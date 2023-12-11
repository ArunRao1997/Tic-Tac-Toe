package src.com.tictactoe.controller;

import src.com.tictactoe.models.Game;
import src.com.tictactoe.models.GameState;
import src.com.tictactoe.models.Player;
import src.com.tictactoe.strategies.winningstrategy.WinningStrategy;

import java.util.List;

public class GameController {
    public Game CreateGame(int dimension, List<Player> players, List<WinningStrategy>winningStrategies){
        try {
            return Game.builder()
                    .setDimension(dimension)
                    .setPlayers(players)
                    .setWinningStrategies(winningStrategies)
                    .build();
        } catch (Exception e){
            System.out.println("Could not start the game, something went wrong");
        }
        return null;
    }

    public void displayBoard(Game game){
        game.board().printBoard();
    }

    public GameState gameState(Game game){
        return game.gameState();
    }

    public void executeMove(Game game){
        int nextPlayerIndex = game.nextPlayerIndex();
        Player nextPlayerToPlay = game.players().get(nextPlayerIndex);
        nextPlayerToPlay.makeMove(game.board());
    }

    public String getWinner(Game game){
        return game.winner().name();
    }
}
