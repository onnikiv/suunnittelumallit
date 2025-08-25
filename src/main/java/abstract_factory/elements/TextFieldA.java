package abstract_factory.elements;

import abstract_factory.interfaces.TextField;

public class TextFieldA extends TextField {

    private String text;

    public TextFieldA(String text) {
        this.text = text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void display() {
        // laiska tapa printtaa
        System.out.println("+".repeat(text.length() + 4));
        System.out.println("| " + text + " |");
        System.out.println("+".repeat(text.length() + 4));
        System.out.println();
    }
}
