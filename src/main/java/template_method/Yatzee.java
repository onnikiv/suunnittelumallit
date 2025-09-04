package template_method;

import java.util.ArrayList;
import java.util.HashMap;

public class Yatzee extends Game {

    private ArrayList<Player> players;
    private HashMap<Integer, Integer> scores;

    @Override
    public void initializeGame(int numberOfPlayers) {

        this.players = new ArrayList<>();
        this.scores = new HashMap<>();

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("PELAAJA " + (i + 1) + ". LISÄTTY");
            this.players.add(new Player(i));
            this.scores.put(i, 0);
        }

    }

    @Override
    public boolean endOfGame() {
        return false;
    }

    @Override
    public void playSingleTurn(int player) {
        Player playerInTurn = this.players.get(player);

        playerInTurn.playPlayerTurn();

        int playerNumber = playerInTurn.getPlayerNumber();

        int currentScore = this.scores.get(playerNumber);
        int turnScore = playerInTurn.getTheSumOfTheDices();
        System.out.println("PELAAJA " + (playerNumber + 1) + ". " + "PISTEET TÄLTÄ VUOROLTA: " + turnScore);
        this.scores.put(playerNumber, currentScore + turnScore);

    }

    @Override
    public void displayWinner() {

    }
}
