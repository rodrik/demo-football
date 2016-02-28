package io.github.rodrik.demo.football.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping(path="/api/hello")
	public String helloWorld() {
		return "Hello World!";
	}
}
