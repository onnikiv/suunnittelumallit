package command.commands;

import command.systems.CursorSystem;

public class MoveCursorDownCommand implements Command {

    private final CursorSystem cursor;

    public MoveCursorDownCommand(CursorSystem cursor) {
        this.cursor = cursor;
    }

    @Override
    public void execute() {
        cursor.moveDown();
    }
}
