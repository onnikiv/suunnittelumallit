package memento;

public class Memento implements IMemento {

    private final int[] options;
    private final boolean isSelected;
    private final String timestamp;
    private final String description;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        this.timestamp = java.time.LocalDateTime.now().toString();
        this.description = "Options: " + options[0] + ", " + options[1] + ", " + options[2] + "; Selected: " + isSelected;
        System.out.println("Memento created");
    }

    public int[] getOptions() {
        return options;
    }

    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
