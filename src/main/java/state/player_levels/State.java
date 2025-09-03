package state.player_levels;

import state.GameCharacter;

public abstract class State {

    private final GameCharacter character;

    public State(GameCharacter character) {
        this.character = character;

    }

    public GameCharacter getCharacter() {
        return character;
    }

    public abstract void action();

}
