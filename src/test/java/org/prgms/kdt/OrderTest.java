package org.prgms.kdt;

import org.junit.jupiter.api.Test;
import org.prgms.kdt.model.Order;
import org.prgms.kdt.model.OrderItem;
import org.prgms.kdt.service.AppConfiguration;
import org.prgms.kdt.service.OrderService;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {

    @Test
    void order_tester() {
        // given
        UUID customerId = UUID.randomUUID();
        AppConfiguration appConfiguration = new AppConfiguration();
        OrderService orderService = appConfiguration.orderService();

        // when
        Order order = orderService.createOrder(customerId, new ArrayList<>() {{
            add(new OrderItem(UUID.randomUUID(), 100L, 1));
        }});

        // then
        assertThat(order.totalAmount())
                .as(MessageFormat.format("totalAmount {0} is not 100L", order.totalAmount()))
                .isEqualTo(100L);
    }
}