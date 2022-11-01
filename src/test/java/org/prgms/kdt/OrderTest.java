package org.prgms.kdt;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {

    @Test
    void order_tester() {
        // given
        var customerId = UUID.randomUUID();
        var orderItems = new ArrayList<OrderItem>() {{
            add(new OrderItem(UUID.randomUUID(), 100L, 1));
        }};

        // when
        var order = new Order(UUID.randomUUID(), customerId, orderItems, 10L);

        // then
        assertThat(order.totalAmount()).as("totalAmount %d is not 90L", order.totalAmount())
                .isEqualTo(90L);
    }
}