package net.impactotecnologico.demo.security.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping(value = "/api/hello")
	public Map<String, String> hello() {
		HashMap<String, String> result = new HashMap<>();
		result.put("Hola", "Mundo");
		return result;
	}

	@GetMapping(value = "/anonnymous")
	public Map<String, String> anon() {
		HashMap<String, String> result = new HashMap<>();
		result.put("Hola", "Anonnymous");
		return result;
	}

}
