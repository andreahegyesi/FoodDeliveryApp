package org.example.factories;
import org.example.food.Burger;
public class BurgerFactory {
    public static Burger getBurger(String type) {
        if (type.equals("Hamburger")) {
            return new HamburgerFactory().create();
        } else if (type.equals("Cheeseburger")) {
            return new CheeseburgerFactory().create();
        } else {
            return null;
        }
    }
}
