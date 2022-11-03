package org.prgms.kdt.service;

import org.junit.jupiter.api.Test;
import org.prgms.kdt.model.Order;
import org.prgms.kdt.model.OrderItem;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class AppConfigurationTest {

    @Test
    void application_context_test() {

        // given

        // Java 기반의 설정을 이용할 경우 AnnotationConfigApplicationContext 구현체를 사용
        var applicationContext
                = new AnnotationConfigApplicationContext(AppConfiguration.class);
        var customerId = UUID.randomUUID();
        var orderService = applicationContext.getBean(OrderService.class); // BeanFactory 의 getBean()

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