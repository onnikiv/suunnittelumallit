package observer;

import java.util.ArrayList;

public class WeatherStation extends Thread {

    private int temperature;
    private static final int MIN_TEMPERATURE = -15;
    private static final int MAX_TEMPERATURE = 25;

    private final ArrayList<Observer> observers;

    public WeatherStation() {
        this.temperature = (int) (Math.random() * (MAX_TEMPERATURE - MIN_TEMPERATURE + 1)) + MIN_TEMPERATURE;
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
                int sleepTime = 1000 + (int) (Math.random() * 4000);
                System.out.println("Sleeping for " + (sleepTime / 1000) + " seconds...");
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {

            }

            if (i == 5) {
                // arvotaan observerien listakoolla random observeri joka poistetaan puolivälissä
                removeObserver(observers.get((int) (Math.random() * observers.size())));
            }

        }
    }

    public void incrementTemperature(int amount) {
        if (this.temperature + amount <= MAX_TEMPERATURE) {
            this.temperature += amount;
            System.out.println("\nWeather incremented, temperature now: " + temperature);
            update();
        }
    }

    public void decrementTemperature(int amount) {
        if (this.temperature - amount >= MIN_TEMPERATURE) {
            this.temperature -= amount;
            System.out.println("\nWeather decremented, temperature now: " + temperature);
            update();
        }
    }

    public void addObserver(Observer observer) {
        System.out.println(">> Added observer: " + observer.getName() + " <<");
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        System.out.println(">> Removed observer: " + observer.getName() + " <<");
        this.observers.remove(observer);
    }

    public int getTemperature() {
        return this.temperature;
    }

    public synchronized void update() {
        int currentTemperature = getTemperature();
        System.out.println();
        for (Observer observer : observers) {
            observer.updateTemperature(currentTemperature);
        }
    }
}
