package net.impactotecnologico.demo.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.impactotecnologico.demo.security.models.User;
import net.impactotecnologico.demo.security.services.SecurityService;
import net.impactotecnologico.demo.security.services.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@GetMapping("/sign-in")
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "sign-in";
	}

	@PostMapping("/sign-in")
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {

		userService.save(userForm);

		securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

		return "redirect:/welcome";
	}

	@GetMapping({ "/", "/welcome" })
	public String welcome(Model model) {
		return "welcome";
	}

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Tu nombre de usuario y contraseña no son válidos.");

		if (logout != null)
			model.addAttribute("message", "Tu login se realizó correctamente");

		System.out.println("Retornaremos la página de login");

		return "login";
	}

}