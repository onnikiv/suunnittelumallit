package command.commands;

import command.systems.CursorSystem;

public class TogglePixelCommand implements Command {

    private final CursorSystem cursor;

    public TogglePixelCommand(CursorSystem cursor) {
        this.cursor = cursor;
    }

    @Override
    public void execute() {
        cursor.togglePixel();
    }
}
