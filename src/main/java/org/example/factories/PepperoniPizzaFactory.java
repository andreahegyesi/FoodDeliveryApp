package org.example.factories;
import org.example.food.PepperoniPizza;
import org.example.food.Pizza;
public class PepperoniPizzaFactory implements PizzaAbstractFactory {
    @Override
    public Pizza create() {
        return new PepperoniPizza();
    }
}
