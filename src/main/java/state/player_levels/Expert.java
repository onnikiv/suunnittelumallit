package state.player_levels;

import state.GameCharacter;

public class Expert extends State {

    public Expert(GameCharacter character) {
        super(character);
    }

    @Override
    public void action() {
        System.out.println("(1) - Train");
        System.out.println("(2) - Meditate");
        System.out.println("(3) - Fight");

        GameCharacter character = this.getCharacter();

        switch (character.userInput()) {
            case 1 -> {
                System.out.println("\nTraining...");
                character.setExperience(25);

                if ((int) character.getExperience() >= 500) {
                    System.out.println(">> LEVEL UP! <<");
                    character.setState(new Master(character));
                    break;
                }
            }

            case 2 -> {
                System.out.println("\nMeditating...");
                character.setHealth(2);
            }

            case 3 -> {
                System.out.println("\nFighting...");
                character.setHealth(-5);
                character.setExperience(40);

                if ((int) character.getExperience() >= 500) {
                    System.out.println(">> LEVEL UP! <<");
                    character.setState(new Master(character));
                    break;
                }
            }
        }
    }
}
