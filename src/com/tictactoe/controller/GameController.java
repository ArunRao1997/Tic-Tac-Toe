package src.com.tictactoe.controller;

import src.com.tictactoe.models.Game;
import src.com.tictactoe.models.GameState;
import src.com.tictactoe.models.Move;
import src.com.tictactoe.models.Player;
import src.com.tictactoe.strategies.winningstrategy.OrderWinningStrategy;
import src.com.tictactoe.strategies.winningstrategy.WinningStrategy;

import java.util.List;

public class GameController {
    public Game CreateGame(int dimension, List<Player> players){
        try {
            return Game.builder()
                    .setDimension(dimension)
                    .setPlayers(players)
                    .setWinningStrategies(List.of(new OrderWinningStrategy(dimension)))
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

//    public void executeMove(Game game){
//        int nextPlayerIndex = game.nextPlayerIndex();
//        Player nextPlayerToPlay = game.players().get(nextPlayerIndex);
//        Move move = nextPlayerToPlay.makeMove(game.board());
//        updateGameMoves(game,move);
//    }

    public Move executeMove(Game game, Player player){
       Move move = player.makeMove(game.board());
       updateGameMoves(game,move);
       return move;
    }

    private void updateGameMoves(Game game, Move move){
        game.moves().add(move);
    }

    public Player checkWinner(Game game, Move recentMove){
        for(WinningStrategy winningStrategy: game.winningStrategies()){
            Player player = winningStrategy.checkWinner(game.board(),recentMove);
            if(player != null){
                return player;
            }
        }
        return null;
    }

    public String getWinner(Game game){
        return game.winner().name();
    }
}
