// ...removed illegal code before package statement...
package memento;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history (undo)
    private List<IMemento> redoHistory; // Redo history

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
        clearRedo();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
        clearRedo();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            IMemento currentState = model.createMemento();
            redoHistory.add(currentState); // Save current state to redo
            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            IMemento currentState = model.createMemento();
            history.add(currentState); // Save current state to undo
            IMemento redoState = redoHistory.remove(redoHistory.size() - 1);
            model.restoreState(redoState);
            gui.updateGui();
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
    }

    private void clearRedo() {
        redoHistory.clear();
    }
}
