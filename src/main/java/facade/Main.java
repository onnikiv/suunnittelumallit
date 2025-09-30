package facade;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        JokeClient client = new JokeClient();
        try {

            System.out.println(client.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value"));
            System.out.println(client.getAttributeValueFromJson("https://api.fxratesapi.com/latest", "rates"));
        } catch (IOException | IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
