package template_method;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private final ArrayList<Dice> diceThrow;
    private static final Scanner scanner = new Scanner(System.in);
    private int sum;
    private final int playerNumber;

    public Player(int playerNumber) {
        this.playerNumber = playerNumber;
        this.sum = 0;
        this.diceThrow = new ArrayList<>();

        // alustetaan noppa oliot listaan
        for (int i = 0; i < 5; i++) {
            this.diceThrow.add(new Dice());
        }
    }

    public void printPlayerNumber() {
        System.out.println(" ".repeat(20) + "| PELAAJA: " + (this.playerNumber + 1) + "  |");

    }

    public int getPlayerNumber() {
        return this.playerNumber;
    }

    public int getTheSumOfTheDices() {
        this.sum = 0;
        for (Dice dice : diceThrow) {
            this.sum += dice.getFace();
        }
        return this.sum;
    }

    public void printTheSumOfTheDices() {
        System.out.println(" ".repeat(20) + "| SUMMA  : " + getTheSumOfTheDices() + " |\n");
    }

    public void shootTheSelectedDices(int dice) {
        // checkataan onko indeksi listan rajoissa 
        // ja setillä uus noppa olio sen kyseisen indeksin tilalle
        int index = dice - 1;
        if (index >= 0 && index < this.diceThrow.size()) {
            this.diceThrow.set(index, new Dice());
        }
    }

    public void playPlayerTurn() {
        // kolme heittoa pelaajalla
        System.out.println("-".repeat(70));

        for (int i = 1; i <= 3; i++) {
            printPlayerNumber();
            System.out.println(" ".repeat(20) + "| HEITTO : " + i + ". |");
            printTheSumOfTheDices();
            sortDices();
            displayThrownDices();
            diceToThrowAgain();
        }

        displayThrownDices();
        printTheSumOfTheDices();
    }

    public void diceToThrowAgain() {
        ArrayList<Integer> selectedDice = new ArrayList<>();
        System.out.println(">> Valitse nopat jotka haluat arpoa uudelleen [syötä nopat yksitellen].\n>> Syötä (0) kun olet tehnyt valintasi.");

        while (true) {

            int dice = scanner.nextInt();
            if (dice == 0) {

                break;
            }

            if (dice < 1 || dice > 5) {
                System.out.println("Ole hyvä ja syötä nopat väliltä (1-5).      Syötä (0) kun olet tehnyt valintasi.");
                continue;
            }

            if (selectedDice.contains(dice)) {
                selectedDice.remove(Integer.valueOf(dice));
            } else {
                selectedDice.add(dice);
            }

            System.out.println("Valitut nopat: " + selectedDice);

        }
        for (int i = 0; i < selectedDice.size(); i++) {
            shootTheSelectedDices(selectedDice.get(i));
        }
        sortDices();
    }

    public void sortDices() {
        this.diceThrow.sort((d1, d2) -> Integer.compare(d1.getFace(), d2.getFace()));
    }

    public void displayThrownDices() {
        System.out.println("  1.        2.        3.        4.        5.");
        System.out.println("-----     -----     -----     -----     -----");
        for (Dice dice : this.diceThrow) {
            System.out.print("| " + dice.getFace() + " |     ");
        }
        System.out.println("\n-----     -----     -----     -----     -----");
    }

}
