package org.prgms.kdt.repository;

import org.prgms.kdt.model.Voucher;

import java.util.Optional;
import java.util.UUID;

// Repository 는 interface로 선언한다. 사용하는 데이터베이스가 변경될 수 있기 때문.
public interface VoucherRepository {

    // Optional을 이용하여 voucherId에 해당하는 Voucher Entity가 없을 수도 있음을 알린다.
    Optional<Voucher> findById(UUID voucherId);

    Voucher insert(Voucher voucher);
}
