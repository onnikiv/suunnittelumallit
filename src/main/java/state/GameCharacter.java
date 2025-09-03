package state;

import java.util.Scanner;

import state.player_levels.Novice;
import state.player_levels.State;

public class GameCharacter {

    private static final Scanner scanner = new Scanner(System.in);
    private final String name;
    private double experience;
    private int health;
    private State state;

    public GameCharacter(String name) {
        this.name = name;
        this.experience = 100;
        this.health = 10;
        state = new Novice(this);
    }

    public void play() {
        System.out.println("New Game Started - Character name: " + this.name + "\n");
        while (true) {
            if (state == null) {
                return;
            }

            if (this.getHealth() <= 0) {
                System.out.println("Oh shucks! You Died!");
                System.out.println(">> GAME OVER <<");
                break;
            }

            if ("MASTER".equals(this.getLevel())) {
                System.out.println("Congratulations!");
                System.out.println(">> GAME WON <<");
                break;
            }

            displayStats();
            state.action();
        }
    }

    public void displayStats() {
        System.out.println(" ".repeat(40) + "Current Stats: ");
        System.out.println(" ".repeat(40) + "LVL:  " + this.getLevel());
        System.out.println(" ".repeat(40) + "HP:   " + this.getHealth());
        System.out.println(" ".repeat(40) + "XP:   " + this.getExperience());
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getLevel() {
        return state.getClass().getSimpleName().toUpperCase();
    }

    public int userInput() {
        return scanner.nextInt();
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(int amount) {
        experience += amount;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int amount) {
        health += amount;
    }
}
