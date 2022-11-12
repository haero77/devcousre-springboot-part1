package org.prgms.voucherapp;

import org.prgms.voucherapp.order.OrderProperties;
import org.prgms.voucherapp.voucher.FixedAmountVoucher;
import org.prgms.voucherapp.voucher.JdbcVoucherRepository;
import org.prgms.voucherapp.voucher.VoucherRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.MessageFormat;
import java.util.UUID;

@SpringBootApplication
public class KdtApplication {

    public static void main(String[] args) {

        var springApplication = new SpringApplication(KdtApplication.class);
//        springApplication.setAdditionalProfiles("dev");
        springApplication.setAdditionalProfiles("local");
        var applicationContext = springApplication.run(args);
//    var applicationContext = SpringApplication.run(KdtApplication.class, args);

        var orderProperties = applicationContext.getBean(OrderProperties.class);
        System.out.println(MessageFormat.format("main(): version -> {0}", orderProperties.getVersion()));
        System.out.println(MessageFormat.format("main(): minimumOrderAmount -> {0}", orderProperties.getMinimumOrderAmount()));
        System.out.println(MessageFormat.format("main(): supportVendors -> {0}", orderProperties.getSupportVendors()));
        System.out.println(MessageFormat.format("main(): description -> {0}", orderProperties.getDescription()));

        var customerId = UUID.randomUUID();
        var voucherRepository = applicationContext.getBean(VoucherRepository.class);
        var voucher = voucherRepository.insert(new FixedAmountVoucher(UUID.randomUUID(), 10L));

        System.out.println(MessageFormat.format("main(): is Jdbc Repo -> {0}", voucherRepository instanceof JdbcVoucherRepository));
        System.out.println(MessageFormat.format("main(): is Jdbc Repo -> {0}", voucherRepository.getClass().getCanonicalName()));
    }

}
