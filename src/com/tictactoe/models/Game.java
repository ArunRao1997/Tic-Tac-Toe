package src.com.tictactoe.models;

import src.com.tictactoe.exception.InvalidBotCountException;
import src.com.tictactoe.exception.InvalidNumberOfPlayersException;
import src.com.tictactoe.exception.ThrowNewInvalidDimension;
import src.com.tictactoe.strategies.winningstrategy.WinningStrategy;
import src.com.tictactoe.exception.DuplicateSymbolException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private int nextPlayerIndex;
    private List<WinningStrategy> winningStrategies;

    public Game(List<Player> players, Board board, List<WinningStrategy> winningStrategies) {
        this.players = players;
        this.board = board;
        this.winningStrategies = winningStrategies;
    }

    public List<Player> players() {
        return players;
    }

    public Board board() {
        return board;
    }

    public List<Move> moves() {
        return moves;
    }

    public Player winner() {
        return winner;
    }

    public GameState gameState() {
        return gameState;
    }

    public int nextPlayerIndex() {
        return nextPlayerIndex;
    }

    public List<WinningStrategy> winningStrategies() {
        return winningStrategies;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int dimension;

        private Builder() {
            this.players = new ArrayList<Player>();
            this.winningStrategies = new ArrayList<WinningStrategy>();
            this.dimension = 0;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public void addPlayer(Player player) {
            players.add(player);
        }

        public void addWinningStrategy(WinningStrategy winningStrategy) {
            winningStrategies.add(winningStrategy);
        }

        public void validateBotCounts() {
            int botCount = 0;
            for (Player player :
                    players) {
                if (player.playerType().equals(PlayerType.BOT)) {
                    botCount++;
                }
                if (botCount > 1) {
                    // throw exception
                    throw new InvalidBotCountException("Bot Count has exceeded one");
                }

            }
        }

        private void validateDimension() {
            if (dimension < 3 || dimension > 10) {
                throw new ThrowNewInvalidDimension("Dimension can be either greater than 2 or less than 11");
            }
        }

        private void validateNumberOfPlayers() {
            if (players.size() != dimension - 1) {
                throw new InvalidNumberOfPlayersException("Players should be 1 less than dimension");
            }
        }

        private void validateUniqueSymbolForAllPlayers() {
            HashSet<Character> set = new HashSet<>();
            for (Player player : players) {
                set.add(player.symbol().symbolChar());
            }
            if (set.size() != players.size()) {
                throw new DuplicateSymbolException("Every Player should have unique symbol");
            }
        }

        public void validate() {
            validateBotCounts();
            validateDimension();
            validateNumberOfPlayers();
            validateUniqueSymbolForAllPlayers();
        }

        public Game build() {
            validate();
            return new Game(players, new Board(dimension), winningStrategies);
        }
    }
}
