package org.example;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Client {
    private String name;
    private Order order;

    public Client(String name) {
        this.name = name;
    }

    public void pickUpTheOrder() {
        System.out.println(name + " has picked up the order " + order.getOrderNumber());
        order.setStatus(OrderStatus.DELIVERED);
    }

    public void update() {
        pickUpTheOrder();
    }

    public void cancelOrder() throws CannotCancelOrderException {
        System.out.println(this.getName() + " is trying to cancel order nr " + order.getOrderNumber());
        if (order.getStatus().equals(OrderStatus.NEW)) {
            order.setStatus(OrderStatus.CANCELLED);
            System.out.println("Order nr " + order.getOrderNumber() + " was CANCELLED");
        } else {
            throw new CannotCancelOrderException("Cannot cancel order nr " + order.getOrderNumber() + " which is " + order.getStatus());
        }
    }
}

