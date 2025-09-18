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

}
