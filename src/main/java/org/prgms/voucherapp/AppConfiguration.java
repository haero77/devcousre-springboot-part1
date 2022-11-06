package org.prgms.voucherapp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.prgms.voucherapp.order", "org.prgms.voucherapp.voucher"})
public class AppConfiguration { // 최상위 폴더에 있을때 ComponentScan과 관련하여 오류가 안 난다.

}
