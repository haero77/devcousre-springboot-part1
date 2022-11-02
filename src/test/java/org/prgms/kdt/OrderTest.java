package org.prgms.kdt;

import org.junit.jupiter.api.Test;
import org.prgms.kdt.model.FixedAmountVoucher;
import org.prgms.kdt.model.Order;
import org.prgms.kdt.model.OrderStatus;

import java.util.ArrayList;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {

    @Test
    void order_tester() {
        // given
        var customerId = UUID.randomUUID();
        var orderItems = new ArrayList<OrderStatus.OrderItem>() {{
            add(new OrderStatus.OrderItem(UUID.randomUUID(), 100L, 1));
        }};
        var fixedAmountVoucher = new FixedAmountVoucher(UUID.randomUUID(), 10L);

        // when
        var order = new Order(UUID.randomUUID(), customerId, orderItems, fixedAmountVoucher);

        // then
        assertThat(order.totalAmount()).as("totalAmount %d is not 90L", order.totalAmount())
                .isEqualTo(90L);
    }
}