package observer;

import java.util.ArrayList;

public class WeatherStation extends Thread {

    private int temperature;

    private final ArrayList<Observer> observers;

    public WeatherStation() {
        this.temperature = (int) (Math.random() * 22);
        this.observers = new ArrayList<>();
        System.out.println("Weatherstation initialized, starting temperature: " + temperature);
    }

    @Override
    public void run() {
        update();
        for (int i = 0; i < 10; i++) {

            switch ((int) (Math.random() * 2)) {
                case 0 ->
                    this.incrementTemperature(1);
                case 1 ->
                    this.decrementTemperature(1);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }

            if (i == 5) {
                removeObserver(observers.get(2));
            }

        }
    }

    public void incrementTemperature(int amount) {
        this.temperature += amount;
        System.out.println("\nWeather incremented, temperature now: " + temperature);
        update();
    }

    public void decrementTemperature(int amount) {
        this.temperature -= amount;
        System.out.println("\nWeather decremented, temperature now: " + temperature);
        update();
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
        System.out.println("Added new observer");
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
        System.out.println(">> Removed observer" + observer + " <<");
    }

    public int getTemperature() {
        return this.temperature;
    }

    public synchronized void update() {
        int currentTemperature = getTemperature();
        for (Observer observer : observers) {
            observer.updateTemperature(currentTemperature);
        }
    }
}
