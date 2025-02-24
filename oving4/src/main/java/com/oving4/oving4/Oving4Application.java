package com.oving4.oving4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@SpringBootApplication
public class Oving4Application {

	public static void main(String[] args) {
		SpringApplication.run(Oving4Application.class, args);
	}

}
