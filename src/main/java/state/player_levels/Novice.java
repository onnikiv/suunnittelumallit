package state.player_levels;

import state.GameCharacter;

public class Novice extends State {

    public Novice(GameCharacter character) {
        super(character);
    }

    @Override
    public void action() {
        System.out.println("(1) - Train");

        GameCharacter character = this.getCharacter();

        switch (character.userInput()) {
            case 1 -> {
                System.out.println("\nTraining...");
                character.setExperience(25);

                if ((int) character.getExperience() == 200) {
                    System.out.println(">> LEVEL UP! <<");
                    character.setState(new Intermediate(character));
                    break;
                }
            }
        }
    }
}
