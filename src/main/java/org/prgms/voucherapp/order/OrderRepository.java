package org.prgms.voucherapp.order;

public interface OrderRepository {
    
    // Order 객체가 어딘가에 저장되므로 영속성 보장
    Order insert(Order order);
}
