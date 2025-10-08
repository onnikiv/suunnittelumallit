package command;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class EditorWindow {

    private static final int GRID_SIZE = 8;
    private Rectangle[][] pixels;
    private boolean[][] pixelState;
    private int currentRow = 0;
    private int currentCol = 0;

    public void setPixels(Rectangle[][] pixels) {
        this.pixels = pixels;
        this.pixelState = new boolean[GRID_SIZE][GRID_SIZE];
    }

    public void updateCursorPosition(String direction) {
        switch (direction) {
            case "down" -> {
                if (currentRow < GRID_SIZE - 1) {
                    currentRow++;
                    updateCurrentPosition();
                }
            }
            case "left" -> {
                if (currentCol > 0) {
                    currentCol--;
                    updateCurrentPosition();
                }
            }
            case "right" -> {
                if (currentCol < GRID_SIZE - 1) {
                    currentCol++;
                    updateCurrentPosition();
                }
            }
            case "up" -> {
                if (currentRow > 0) {
                    currentRow--;
                    updateCurrentPosition();
                }
            }
            default ->
                throw new AssertionError();
        }
    }

    public void togglePixel() {
        pixelState[currentRow][currentCol] = !pixelState[currentRow][currentCol];
        Rectangle pixel = pixels[currentRow][currentCol];

        if (pixelState[currentRow][currentCol]) {
            pixel.setFill(Color.BLACK);
        } else {
            pixel.setFill(Color.WHITE);
        }
    }

    public void generateCode() {
        StringBuilder code = new StringBuilder();
        code.append("int[][] pixelArt = {\n");

        for (int row = 0; row < GRID_SIZE; row++) {
            code.append("    {");
            for (int col = 0; col < GRID_SIZE; col++) {
                code.append(pixelState[row][col] ? "1" : "0");
                if (col < GRID_SIZE - 1) {
                    code.append(", ");
                }
            }
            code.append("}");
            if (row < GRID_SIZE - 1) {
                code.append(",");
            }
            code.append("\n");
        }
        code.append("};");

        System.out.println("Generated Java code:");
        System.out.println(code.toString());
    }

    private void updateCurrentPosition() {
        if (pixels == null) {
            return;
        }

        // Reset all pixels to normal stroke width
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                pixels[row][col].setStrokeWidth(1);
                pixels[row][col].setStroke(Color.BLACK);
            }
        }

        // Highlight current pixel with thicker red border
        pixels[currentRow][currentCol].setStrokeWidth(3);
        pixels[currentRow][currentCol].setStroke(Color.RED);
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }
}
