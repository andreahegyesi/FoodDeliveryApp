package org.example;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.food.Food;
@Getter
@Setter
@ToString
public class Order {
    private int orderNumber;
    private OrderStatus status;
    private Client client;
    private Food food;

    public Order(int orderNumber, Client client, Food food) {
        this.orderNumber = orderNumber;
        this.status = OrderStatus.NEW;
        this.client = client;
        this.client.setOrder(this);
        this.food = food;
        System.out.println("Received order nr " + orderNumber + " for client " + client.getName());
    }

    public void inform(String message) {
        System.out.println(message);
        client.update();
    }
}

