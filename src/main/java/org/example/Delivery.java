package org.example;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class Delivery {
    private List<Order> orderList = new ArrayList<>();

    public void addOrder(Order order) {
        orderList.add(order);
    }
}
