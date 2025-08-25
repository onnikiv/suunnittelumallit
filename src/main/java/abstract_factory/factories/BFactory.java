package abstract_factory.factories;

import abstract_factory.elements.ButtonB;
import abstract_factory.elements.CheckboxB;
import abstract_factory.elements.TextFieldB;
import abstract_factory.interfaces.Button;
import abstract_factory.interfaces.Checkbox;
import abstract_factory.interfaces.TextField;

public class BFactory extends UIFactory {

    @Override
    public Button createButton(String text) {
        return new ButtonB(text);
    }

    @Override
    public TextField createTextField(String text) {
        return new TextFieldB(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxB(text);
    }
}
