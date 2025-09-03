package template_method;

public final class Dice {

    private int face;

    public Dice() {
        this.face = (int) (Math.random() * 6) + 1;
    }

    public int getFace() {
        return this.face;
    }
}
