package command.commands;

import command.systems.CursorSystem;

public class MoveCursorRightCommand implements Command {

    private final CursorSystem cursor;

    public MoveCursorRightCommand(CursorSystem cursor) {
        this.cursor = cursor;
    }

    @Override
    public void execute() {
        cursor.moveRight();
    }
}
