package org.example.factories;
import org.example.food.Burger;
import org.example.food.Cheeseburger;
public class CheeseburgerFactory implements BurgerAbstractFactory {
    @Override
    public Burger create() {
        return new Cheeseburger();
    }
}