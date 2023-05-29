package com.oxcentra.menumaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.oxcentra.menumaster"})
public class MenuMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuMasterApplication.class, args);
	}

}
