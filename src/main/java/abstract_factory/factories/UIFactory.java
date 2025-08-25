package abstract_factory.factories;

import abstract_factory.interfaces.Button;
import abstract_factory.interfaces.Checkbox;
import abstract_factory.interfaces.TextField;

public abstract class UIFactory {

    public abstract Button createButton(String text);

    public abstract TextField createTextField(String text);

    public abstract Checkbox createCheckbox(String text);
}
