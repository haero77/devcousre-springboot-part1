package org.prgms.voucherapp.order;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.List;

@Component
public class OrderProperties implements InitializingBean {

    @Value("${voucherapp.version: defaultValue}")
    private String version;

    @Value("3")
    private Integer minimumOrderAmount;

    @Value("a, b, c")
    private List<String> supportVendors;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(MessageFormat.format("[OrderProperties version-> {0}", version));
        System.out.println(MessageFormat.format("[OrderProperties minimumOrderAmount-> {0}", minimumOrderAmount));
        System.out.println(MessageFormat.format("[OrderProperties supportVouchers -> {0}", supportVendors));
    }
}
