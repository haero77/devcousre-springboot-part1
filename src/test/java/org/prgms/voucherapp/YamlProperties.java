package org.prgms.voucherapp;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.List;

class YamlPropertiesTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfiguration.class);

    @Test
    void test() {
        Environment environment = ac.getEnvironment();

        String version = environment.getProperty("kdt.version");
        Integer property = environment.getProperty("kdt.minimum-order-amount", Integer.class);
        var vendors = environment.getProperty("kdt.support-vendors", List.class);

        System.out.println("vendors = " + version);
        System.out.println("property = " + property);
        System.out.println("vendors = " + vendors);
    }
}
