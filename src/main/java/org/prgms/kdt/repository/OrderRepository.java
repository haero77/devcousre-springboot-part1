package org.prgms.kdt.repository;

import org.prgms.kdt.model.Order;

public interface OrderRepository {
    
    // Order 객체가 어딘가에 저장되므로 영속성 보장
    Order insert(Order order);
}
