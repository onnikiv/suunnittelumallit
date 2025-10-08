package command.commands;

import command.systems.CursorSystem;

public class MoveCursorUpCommand implements Command {

    private final CursorSystem cursor;

    public MoveCursorUpCommand(CursorSystem cursor) {
        this.cursor = cursor;
    }

    @Override
    public void execute() {
        cursor.moveUp();
    }
}
