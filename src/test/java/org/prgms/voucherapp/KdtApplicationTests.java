package org.prgms.voucherapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.List;

@SpringBootTest
class KdtApplicationTests {

	ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfiguration.class);

	@Test
	@DisplayName("properties test")
	void properties_test() {
		Environment environment = ac.getEnvironment();
		String version = environment.getProperty("version");
		Integer property = environment.getProperty("voucherapp.minimum-order-amount", Integer.class);
		var vendors = environment.getProperty("voucherapp.support-vendors", List.class);

		System.out.println(property);
		System.out.println(version);
		System.out.println(vendors);
	}
}
