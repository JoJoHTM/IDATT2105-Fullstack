package com.oving5.oving5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@SpringBootApplication
public class Oving5Application {

	public static void main(String[] args) {
		SpringApplication.run(Oving5Application.class, args);
	}

}
