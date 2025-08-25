package abstract_factory;

import abstract_factory.factories.AFactory;
import abstract_factory.factories.BFactory;
import abstract_factory.factories.UIFactory;
import abstract_factory.interfaces.Button;
import abstract_factory.interfaces.Checkbox;
import abstract_factory.interfaces.TextField;

public class Main {

    public static void main(String[] args) {
        UIFactory factoryA = new AFactory();
        UIFactory factoryB = new BFactory();

        // Button A
        Button buttonA = factoryA.createButton("Button A");
        buttonA.display();
        buttonA.setText("Button A now");
        buttonA.display();

        // Button B
        Button buttonB = factoryB.createButton("Button B");
        buttonB.display();
        buttonB.setText("Button B now");
        buttonB.display();

        // Checkbox A 
        Checkbox checkboxA = factoryA.createCheckbox("Checkbox A");
        checkboxA.display();
        checkboxA.setText("Checkbox A now");
        checkboxA.display();
        checkboxA.setText("Checkbox A now \n");
        checkboxA.display();

        // Checkbox B
        Checkbox checkboxB = factoryB.createCheckbox("Checkbox B");
        checkboxB.display();
        checkboxB.setText("Checkbox B now");
        checkboxB.display();

        // Checkbox A 
        TextField TextFieldA = factoryA.createTextField("TextField A");
        TextFieldA.display();
        TextFieldA.setText("TextField A now");
        TextFieldA.display();

        // Checkbox B
        TextField TextFieldB = factoryB.createTextField("TextField B");
        TextFieldB.display();
        TextFieldB.setText("TextField B now");
        TextFieldB.display();

    }
}
