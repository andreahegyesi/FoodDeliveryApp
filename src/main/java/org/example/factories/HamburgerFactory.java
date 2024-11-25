package org.example.factories;
import org.example.food.Burger;
import org.example.food.Hamburger;
public class HamburgerFactory implements BurgerAbstractFactory {
    @Override
    public Burger create() {
        return new Hamburger();
    }
}