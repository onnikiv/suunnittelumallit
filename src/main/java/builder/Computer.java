package builder;

import java.util.ArrayList;

public class Computer {

    private final ArrayList<Component> components;

    public Computer() {
        this.components = new ArrayList<>();
    }

    public void addComponent(Component component) {
        this.components.add(component);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Component component : components) {
            sb.append(component.getName());
            sb.append("\n");
        }
        return sb.toString();
    }
}
