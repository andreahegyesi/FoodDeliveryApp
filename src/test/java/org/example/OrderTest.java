package org.example;
import org.example.factories.BurgerFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class OrderTest {

    Client testClient = new Client("TestClient");

    @Test
    void inform() {
        Order testOrder = new Order(12, testClient, BurgerFactory.getBurger("Hamburger"));
        testOrder.setStatus(OrderStatus.READY);
        testOrder.inform("testorder ready");
        assertEquals(OrderStatus.DELIVERED, testOrder.getStatus());
    }
}