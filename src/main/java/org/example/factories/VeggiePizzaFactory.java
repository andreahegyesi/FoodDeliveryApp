package org.example.factories;
import org.example.food.VeggiePizza;
import org.example.food.Pizza;
public class VeggiePizzaFactory implements PizzaAbstractFactory {
    @Override
    public Pizza create() {
        return new VeggiePizza();
    }
}