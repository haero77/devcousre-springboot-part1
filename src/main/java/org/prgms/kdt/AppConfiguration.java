package org.prgms.kdt;

import org.prgms.kdt.model.Order;
import org.prgms.kdt.repository.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfiguration { // 최상위 폴더에 있을때 ComponentScan과 관련하여 오류가 안 난다. 

    @Bean
    public OrderRepository orderRepository() {
        return new OrderRepository() {
            @Override
            public void insert(Order order) {

            }
        };
    }
}
