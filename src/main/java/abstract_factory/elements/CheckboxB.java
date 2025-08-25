package abstract_factory.elements;

import abstract_factory.interfaces.Checkbox;

public class CheckboxB extends Checkbox {

    private String text;
    private boolean checked = false;

    public CheckboxB(String text) {
        this.text = text;
        this.checked = true;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void display() {
        // vähän maustetta
        this.checked = !checked;
        if (checked) {
            System.out.println("(X) " + text);
        } else {
            System.out.println("( ) " + text);
        }
        System.out.println();
    }
}
