package net.impactotecnologico.demo.security.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

//@RestController
//@RequestMapping(InfoRestController.URL_RESOURCE)
@Controller
public class InfoRestController {

	public static final String URL_RESOURCE = "/info";

	@GetMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void info() {

	}

}