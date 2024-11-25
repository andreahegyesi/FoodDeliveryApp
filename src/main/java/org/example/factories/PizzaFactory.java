package org.example.factories;
import org.example.food.Pizza;
public class PizzaFactory {
    public static Pizza getPizza(String type) {
        if (type.equals("PepperoniPizza")) {
            return new PepperoniPizzaFactory().create();
        } else if (type.equals("VeggiePizza")) {
            return new VeggiePizzaFactory().create();
        } else {
            return null;
        }
    }
}
