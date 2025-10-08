package command.commands;

import command.systems.CursorSystem;

public class MoveCursorLeftCommand implements Command {

    private final CursorSystem cursor;

    public MoveCursorLeftCommand(CursorSystem cursor) {
        this.cursor = cursor;
    }

    @Override
    public void execute() {
        cursor.moveLeft();
    }
}
