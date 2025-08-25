package abstract_factory.factories;

import abstract_factory.elements.ButtonA;
import abstract_factory.elements.CheckboxA;
import abstract_factory.elements.TextFieldA;
import abstract_factory.interfaces.Button;
import abstract_factory.interfaces.Checkbox;
import abstract_factory.interfaces.TextField;

public class AFactory extends UIFactory {

    @Override
    public Button createButton(String text) {
        return new ButtonA(text);
    }

    @Override
    public TextField createTextField(String text) {
        return new TextFieldA(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxA(text);
    }
}
