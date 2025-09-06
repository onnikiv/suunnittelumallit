package template_method;

import java.util.ArrayList;
import java.util.HashMap;

public class Yatzee extends Game {

    private ArrayList<Player> players;
    private HashMap<Integer, Integer> scores;
    private int round = 0;
    private static final int MAX_ROUNDS = 5; // otetaan vaan 5 roundii

    @Override
    public void initializeGame(int numberOfPlayers) {

        this.players = new ArrayList<>();
        this.scores = new HashMap<>();

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("PELAAJA " + (i + 1) + ". LISÄTTY");
            this.players.add(new Player(i));
            this.scores.put(i, 0);
        }
        this.round = 0;

    }

    @Override
    public boolean endOfGame() {
        return this.round >= MAX_ROUNDS * this.players.size();
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
        this.round++;

    }

    @Override
    public void displayWinner() {
        int winner = -1;
        int maxScore = Integer.MIN_VALUE;
        for (int player : scores.keySet()) {
            int score = scores.get(player);
            System.out.println("PELAAJA " + (player + 1) + ": " + score + " pistettä");
            if (score > maxScore) {
                maxScore = score;
                winner = player;
            }
        }
        System.out.println("\nVOITTAJA ON PELAAJA " + (winner + 1) + "! PISTEET: " + maxScore);
    }
}
