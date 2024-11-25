package org.example;
import org.example.factories.BurgerFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ClientTest {
    static Client testClient = new Client("TestClient");

    @Test
    public void testCancelOrderWhenStatusIsNotNew() {
        Order testOrder = new Order(12, testClient, BurgerFactory.getBurger("Hamburger"));
        testOrder.setStatus(OrderStatus.PROCESSING);
        testClient.setOrder(testOrder);
        assertThrows(CannotCancelOrderException.class, () -> testClient.cancelOrder());
    }
}
