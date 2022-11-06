package org.prgms.kdt.service;

import org.prgms.kdt.model.Voucher;
import org.prgms.kdt.repository.VoucherRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VoucherService {
    private final VoucherRepository voucherRepository;

    public VoucherService(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }

    public Voucher getVoucher(UUID voucherId) {
        return voucherRepository
                .findById(voucherId)
                .orElseThrow(() -> new RuntimeException("Cannot find a voucher for" + voucherId));
    }

    public void useVoucher(Voucher voucher) {

    }
}
