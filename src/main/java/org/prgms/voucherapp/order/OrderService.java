package org.prgms.voucherapp.order;

import org.prgms.voucherapp.voucher.Voucher;
import org.prgms.voucherapp.voucher.VoucherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    // OrderService는 voucherService와 orderRepository에 의존
    private final VoucherService voucherService;
    private final OrderRepository orderRepository;

    public OrderService(VoucherService voucherService, OrderRepository orderRepository) {
        this.voucherService = voucherService;
        this.orderRepository = orderRepository;
    }

    // OrderService는 Order Entity 를 생성하는 책임이 있다.
    public Order createOrder(UUID customerId, List<OrderItem> orderItems) {
        Order order = new Order(UUID.randomUUID(), customerId, orderItems);
        return orderRepository.insert(order);
    }

    public Order createOrder(UUID customerId, List<OrderItem> orderItems, UUID voucherId) {
        Voucher voucher = voucherService.getVoucher(voucherId);
        Order order = new Order(UUID.randomUUID(), customerId, orderItems, voucher);
        orderRepository.insert(order);
        voucherService.useVoucher(voucher);
        return order;
    }
}
