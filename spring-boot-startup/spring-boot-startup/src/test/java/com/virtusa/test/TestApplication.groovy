package com.virtusa.test

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.virtusa.shipment.ApplicationLauncher;

@RunWith(SpringJUnit4ClassRunner)
@SpringApplicationConfiguration(classes = ApplicationLauncher)
@WebAppConfiguration
public class TestApplication {

	@Test
	void contextLoads() {
	}

}
