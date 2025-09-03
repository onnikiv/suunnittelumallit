package template_method;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class DiceThrow {

    private ArrayList<Dice> diceThrow;
    private static final Scanner scanner = new Scanner(System.in);

    public DiceThrow() {
        this.diceThrow = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            this.diceThrow.add(new Dice());
        }
        this.diceThrow.sort(Comparator.comparingInt(Dice::getFace));
        displayDice();
    }

    public void throwNew(int dice) {

        switch (dice) {
            case 0 -> {
                this.diceThrow.set(0, new Dice());
            }
            case 1 -> {
                this.diceThrow.set(1, new Dice());
            }
            case 2 -> {
                this.diceThrow.set(2, new Dice());
            }
            case 3 -> {
                this.diceThrow.set(3, new Dice());
            }
            case 4 -> {
                this.diceThrow.set(4, new Dice());
            }

        }
    }

    public void diceToThrowAgain() {
        ArrayList<Integer> diceToThrow = new ArrayList<>();
        System.out.println("Select dices to throw again:    Enter (0) to quit.");

        while (true) {
            int dice = scanner.nextInt();

            if (dice == 0) {
                break;
            }

            if (diceToThrow.contains(dice)) {
                diceToThrow.remove(Integer.valueOf(dice));
            } else {
                diceToThrow.add(dice);
            }

            System.out.println("Selected dices: " + diceToThrow);

        }

        for (int i = 0; i <= diceToThrow.size(); i++) {
            throwNew(i);
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
