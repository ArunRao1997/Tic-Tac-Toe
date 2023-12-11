package src.com.tictactoe;

import src.com.tictactoe.controller.GameController;
import src.com.tictactoe.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameController gameController = new GameController();

        System.out.println("Please enter the dimensions of the game");
        int dimension = sc.nextInt();
        System.out.println("Will there be any bot in the game ? Y/N");
        String isBotPresent = sc.next();

        List<Player> players = new ArrayList<>();
        int iteratorNumber = dimension - 1;

        if (isBotPresent.equals("Y")) {
            iteratorNumber = dimension - 2;
        }

        for (int i = 0; i < iteratorNumber; i++) {
            System.out.println("What is the name of the player number :" + i + 1);
            String playerName = sc.next();

            System.out.println("What is the character symbol of the player :" + i + 1);
            String charSymbol = sc.next();

            players.add(new Player(new Symbol(charSymbol.charAt(0)), playerName, PlayerType.HUMAN));
        }

        if (isBotPresent.equals("Y")) {
            System.out.println("What is the name of the BOT :");
            String playerName = sc.next();

            System.out.println("What is the character symbol of the player :");
            String charSymbol = sc.next();

            players.add(new Player(new Symbol(charSymbol.charAt(0)), playerName, PlayerType.BOT));
        }
        Game game = gameController.CreateGame(dimension, players);

        while (game.gameState().equals(GameState.IN_PROGRESS)) {
            System.out.println("Current Board Status");
            gameController.displayBoard(game);

            // TODO : Undo

            gameController.executeMove(game);
            // TODO : Write logic for giving each player option to play
        }
        System.out.println("Game has ended, result was : ");
        if (gameController.gameState(game).equals(GameState.DRAW)) {
            System.out.println("Game was a Draw");
        } else {
            System.out.println("Game is won by : " + gameController.getWinner(game));
        }
    }
}
