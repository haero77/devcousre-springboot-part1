package org.prgms.kdt.service;

import org.prgms.kdt.model.Order;
import org.prgms.kdt.model.Voucher;
import org.prgms.kdt.repository.OrderRepository;
import org.prgms.kdt.repository.VoucherRepository;

import java.util.Optional;
import java.util.UUID;

public class OrderContext {

    public VoucherRepository voucherRepository() {
        return new VoucherRepository() {
            @Override
            public Optional<Voucher> findById(UUID voucherId) {
                return Optional.empty();
            }
        };
    }

    public OrderRepository orderRepository() {
        return new OrderRepository() {
            @Override
            public void insert(Order order) {

            }
        };
    }

    public VoucherService voucherService() {
        return new VoucherService(voucherRepository());
    }

    public OrderService orderService() {
        return new OrderService(voucherService(), orderRepository());
    }
}
