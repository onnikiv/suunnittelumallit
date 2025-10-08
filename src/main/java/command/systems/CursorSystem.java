package command.systems;

import command.EditorWindow;

public class CursorSystem {

    private final EditorWindow editorWindow;

    public CursorSystem(EditorWindow editorWindow) {
        this.editorWindow = editorWindow;
    }

    public void moveDown() {
        System.out.println("Moving Down");
        editorWindow.updateCursorPosition("down");
    }

    public void moveLeft() {
        System.out.println("Moving Left");
        editorWindow.updateCursorPosition("left");
    }

    public void moveRight() {
        System.out.println("Moving Right");
        editorWindow.updateCursorPosition("right");
    }

    public void moveUp() {
        System.out.println("Moving Up");
        editorWindow.updateCursorPosition("up");
    }

    public void togglePixel() {
        System.out.println("Toggling pixel at (" + editorWindow.getCurrentRow() + ", " + editorWindow.getCurrentCol() + ")");
        editorWindow.togglePixel();
    }

    public void generateCode() {
        System.out.println("Generating code...");
        editorWindow.generateCode();
    }
}
