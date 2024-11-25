package org.example;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
@Getter
@Setter
public class Cook implements Runnable {
    private String name;
    private Order currentOrder;
    private Delivery delivery;

    public Cook(String name, Delivery delivery) {
        this.name = name;
        this.delivery = delivery;
    }

    @Override
    public void run() {
        while (true) {
            this.currentOrder = null;
            synchronized (delivery.getOrderList()) {
                for (Order o : delivery.getOrderList()) {
                    if (o.getStatus().equals(OrderStatus.NEW)) {
                        this.currentOrder = o;
                        break;
                    }
                }
            }
            if (this.currentOrder == null) {
                System.out.println(name + " has finished for today!");
                break;
            }
            this.currentOrder.setStatus(OrderStatus.PROCESSING);
            System.out.println(name + " is starting preparing order nr " + currentOrder.getOrderNumber() + " (" + currentOrder.getFood().prepare() + ")");
            try {
                Thread.sleep(5000 + new Random().nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentOrder.setStatus(OrderStatus.READY);
            System.out.println(name + " has finished preparing order nr " + currentOrder.getOrderNumber());
            currentOrder.inform("Order " + currentOrder.getOrderNumber() + " is ready!");
            currentOrder = null;
        }
    }
}
