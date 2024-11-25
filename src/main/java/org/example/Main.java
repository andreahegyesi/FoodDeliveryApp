package org.example;
import org.example.factories.BurgerFactory;
import org.example.factories.PizzaFactory;
/**
 * This program simulates a scenario in a food delivery app, which includes the following steps:
 * 1. Display a welcome message and available food items.
 * 2. Create a delivery instance to manage orders.
 * 3. Place several orders with different items and clients.
 * 4. Attempt to cancel an order with exception handling for CannotCancelOrderException.
 * 5. Start two cooks as threads to process the orders concurrently.
 * 6. Wait for both cooking threads to finish their work.
 * 7. Notify the clients to pick up their orders.
 * 8. Attempt to cancel a delivered order with exception handling for CannotCancelOrderException.
 */
class Main {
    private static int orderCounter = 1;

    public static void main(String[] args) throws InterruptedException, CannotCancelOrderException {
        System.out.println("Welcome to the FoodDelivery App!");
        System.out.println("You can choose from the following items: Hamburger, Cheeseburger, Pepperoni Pizza and Veggie Pizza.");
        Delivery delivery = new Delivery();
        Order order1 = new Order(orderCounter++, new Client("A"), BurgerFactory.getBurger("Hamburger"));
        delivery.addOrder(order1);
        Order order2 = new Order(orderCounter++, new Client("B"), PizzaFactory.getPizza("VeggiePizza"));
        delivery.addOrder(order2);
        Order order3 = new Order(orderCounter++, new Client("C"), BurgerFactory.getBurger("Cheeseburger"));
        delivery.addOrder(order3);
        Order order4 = new Order(orderCounter++, new Client("D"), BurgerFactory.getBurger("Cheeseburger"));
        delivery.addOrder(order4);
        Order order5 = new Order(orderCounter++, new Client("E"), PizzaFactory.getPizza("PepperoniPizza"));
        delivery.addOrder(order5);
        try {
            order3.getClient().cancelOrder();
        } catch (CannotCancelOrderException e) {
            System.out.println(e.getMessage());
        }
        Thread cook1 = new Thread(new Cook("Cook1", delivery));
        Thread cook2 = new Thread(new Cook("Cook2", delivery));
        cook1.start();
        cook2.start();
        cook1.join();
        cook2.join();
        try {
            order4.getClient().cancelOrder();
        } catch (CannotCancelOrderException e) {
            System.out.println(e.getMessage());
        }
    }
}