package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {


	@GetMapping("/order")
	public String order(@RequestParam(value = "name", defaultValue = "World") String name) {
		return  "order received";
	}
}