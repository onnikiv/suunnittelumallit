package state.player_levels;

import state.GameCharacter;

public class Intermediate extends State {

    public Intermediate(GameCharacter character) {
        super(character);
    }

    @Override
    public void action() {
        System.out.println("(1) - Train");
        System.out.println("(2) - Meditate");

        GameCharacter character = this.getCharacter();

        switch (character.userInput()) {
            case 1 -> {
                System.out.println("\nTraining...");
                character.setExperience(25);

                if ((int) character.getExperience() == 300) {
                    System.out.println(">> LEVEL UP! <<");
                    character.setState(new Expert(character));
                    break;
                }
            }

            case 2 -> {
                System.out.println("\nMeditating...");
                character.setHealth(2);
            }
        }
    }
}
