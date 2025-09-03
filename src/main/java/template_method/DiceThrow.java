package template_method;

import java.util.ArrayList;
import java.util.Scanner;

public class DiceThrow {

    private final ArrayList<Dice> diceThrow;
    private static final Scanner scanner = new Scanner(System.in);

    public DiceThrow() {
        this.diceThrow = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            this.diceThrow.add(new Dice());
        }

        displayDice();
    }

    public void throwNew(int dice) {
        int index = dice - 1;
        if (index >= 0 && index < this.diceThrow.size()) {
            this.diceThrow.set(index, new Dice());
        }
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

        displayDice();
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
