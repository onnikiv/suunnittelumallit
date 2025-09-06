package template_method;

public class Main {

    /**
     * Köyhän miehen Yatzee peli. Pelataan 5 roundia. Voittaja on se joka on
     * summannut eniten pisteitä (noppien silmälukujen summia) pelin lopuksi.
     *
     * Todo: tulevaisuudessa mahdollisesti ohjelmoida peliin loput
     * toiminnallisuudet. Mutta tähän tehtävään tullut käytettyä muutenkin vähän
     * liikaa aikaa, joten aika siirtyä seuraavaan.
     */
    public static void main(String[] args) {
        Yatzee yatzee = new Yatzee();
        yatzee.play(2);
    }
}
