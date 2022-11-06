package org.prgms.voucherapp.voucher;

import java.util.UUID;

public interface Voucher {

    UUID getVoucherId(); // Entity 는 ID를 가져야한다.

    long discount(long beforeDiscount);
}
