package observer;

public class Main {

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        weatherStation.addObserver(new ConcreteObserver("Observer 1"));
        weatherStation.addObserver(new ConcreteObserver("Observer 2"));
        weatherStation.addObserver(new ConcreteObserver("Observer 3"));

        weatherStation.start();

    }
}
