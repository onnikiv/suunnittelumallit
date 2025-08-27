package observer;

public class ConcreteObserver implements Observer {

    private final String name;
    private int temperature;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void updateTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println(this.getName() + " temperature updated to " + temperature);
    }
}
