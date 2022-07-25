package com.barclays.homeloan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HomeloanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeloanApplication.class, args);
	}

	@GetMapping("/")
	public static String homePage() {
		return "this is home";
	}
}
