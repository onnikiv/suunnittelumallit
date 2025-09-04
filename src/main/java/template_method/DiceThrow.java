package template_method;

import java.util.ArrayList;
import java.util.Scanner;

public class DiceThrow {

    private final ArrayList<Dice> diceThrow;
    private static final Scanner scanner = new Scanner(System.in);

    private int sum;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public DiceThrow() {
        this.sum = 0;
        this.diceThrow = new ArrayList<>();

        initializeDices();
    }

    public void initializeDices() {
        for (int i = 0; i < 5; i++) {
            this.diceThrow.add(new Dice());
        }
    }

    public void printSum() {
        System.out.println(" ".repeat(70) + "| SUMMA  : " + getSum() + " |");
    }

    public int getSum() {
        this.sum = 0;
        for (Dice dice : diceThrow) {
            this.sum += dice.getFace();
        }
        return this.sum;
    }

    public void throwNew(int dice) {
        int index = dice - 1;
        if (index >= 0 && index < this.diceThrow.size()) {
            this.diceThrow.set(index, new Dice());
        }
    }

    public void testPlay() {
        System.out.println();
        for (int i = 1; i <= 3; i++) {
            System.out.println(" ".repeat(70) + "| HEITTO : " + i + ". |");
            printSum();
            displayDice();
            diceToThrowAgain();
        }
        System.out.println("Tämän vuoron summa: ");
        printSum();
    }

    public void diceToThrowAgain() {
        ArrayList<Integer> diceToThrow = new ArrayList<>();
        System.out.println("Select dices to throw again (1-5):    Enter (0) to quit.");

        while (true) {

            int dice = scanner.nextInt();

            if (dice == 0) {

                break;
            }

            // Validate input
            if (dice < 1 || dice > 5) {
                System.out.println("Invalid input! Please enter a number between 1 and 5, or 0 to quit.");
                continue;
            }

            if (diceToThrow.contains(dice)) {
                diceToThrow.remove(Integer.valueOf(dice));
            } else {
                diceToThrow.add(dice);
            }

            System.out.println("Selected dices: " + diceToThrow);

        }
        System.out.println("Selected dices: " + diceToThrow);

        for (int i = 0; i < diceToThrow.size(); i++) {
            throwNew(diceToThrow.get(i));
        }

    }

    public void displayDice() {
        System.out.println("  1.        2.        3.        4.        5.");
        System.out.println("-----     -----     -----     -----     -----");
        System.out.print("| " + this.diceThrow.get(0).getFace() + " |     ");
        System.out.print("| " + this.diceThrow.get(1).getFace() + " |     ");
        System.out.print("| " + this.diceThrow.get(2).getFace() + " |     ");
        System.out.print("| " + this.diceThrow.get(3).getFace() + " |     ");
        System.out.print("| " + this.diceThrow.get(4).getFace() + " |");
        System.out.println("\n-----     -----     -----     -----     -----");
    }

}
