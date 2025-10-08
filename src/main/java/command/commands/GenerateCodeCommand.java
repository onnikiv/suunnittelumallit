package command.commands;

import command.systems.CursorSystem;

public class GenerateCodeCommand implements Command {

    private final CursorSystem cursor;

    public GenerateCodeCommand(CursorSystem cursor) {
        this.cursor = cursor;
    }

    @Override
    public void execute() {
        cursor.generateCode();
    }
}
