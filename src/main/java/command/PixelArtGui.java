package command;

import command.commands.Command;
import command.commands.GenerateCodeCommand;
import command.commands.MoveCursorDownCommand;
import command.commands.MoveCursorLeftCommand;
import command.commands.MoveCursorRightCommand;
import command.commands.MoveCursorUpCommand;
import command.commands.TogglePixelCommand;
import command.systems.CursorSystem;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PixelArtGui extends Application {

    private static final int GRID_SIZE = 8;
    private static final int PIXEL_SIZE = 40;
    private Rectangle[][] pixels;

    // Command pattern components
    private EditorWindow editorWindow;
    private CursorSystem cursorSystem;
    private Command moveUpCommand;
    private Command moveDownCommand;
    private Command moveLeftCommand;
    private Command moveRightCommand;
    private Command togglePixelCommand;
    private Command generateCodeCommand;

    @Override
    public void start(Stage stage) {
        // Initialization
        editorWindow = new EditorWindow();
        cursorSystem = new CursorSystem(editorWindow);

        // Commands
        moveUpCommand = new MoveCursorUpCommand(cursorSystem);
        moveDownCommand = new MoveCursorDownCommand(cursorSystem);
        moveLeftCommand = new MoveCursorLeftCommand(cursorSystem);
        moveRightCommand = new MoveCursorRightCommand(cursorSystem);
        togglePixelCommand = new TogglePixelCommand(cursorSystem);
        generateCodeCommand = new GenerateCodeCommand(cursorSystem);

        // Grid of pixels
        GridPane grid = new GridPane();
        pixels = new Rectangle[GRID_SIZE][GRID_SIZE];

        // visualize the 8x8 pixel grid
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Rectangle pixel = new Rectangle(PIXEL_SIZE, PIXEL_SIZE);
                pixel.setFill(Color.WHITE);
                pixel.setStroke(Color.BLACK);
                pixel.setStrokeWidth(1);

                pixels[row][col] = pixel;
                grid.add(pixel, col, row);
            }
        }
        editorWindow.setPixels(pixels);

        Button createCodeButton = new Button("Create Code");
        createCodeButton.setOnAction(e -> generateCodeCommand.execute());

        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(10));
        mainLayout.getChildren().addAll(grid, createCodeButton);

        Scene scene = new Scene(mainLayout, GRID_SIZE * PIXEL_SIZE + 20, GRID_SIZE * PIXEL_SIZE + 70);

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP ->
                    moveUpCommand.execute();
                case DOWN ->
                    moveDownCommand.execute();
                case LEFT ->
                    moveLeftCommand.execute();
                case RIGHT ->
                    moveRightCommand.execute();
                case SPACE ->
                    togglePixelCommand.execute();
                case C -> {
                    if (e.isControlDown()) {
                        generateCodeCommand.execute();
                    }
                }
                default -> {
                }
            }
        });

        stage.setTitle("Pixel Art Editor - Use arrow keys to move, space to toggle, button/Ctrl+C to generate code");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        // Initialize cursor position highlight
        pixels[0][0].setStrokeWidth(3);
        pixels[0][0].setStroke(Color.RED);

        // Request focus so keyboard events work
        scene.getRoot().requestFocus();
    }

}
