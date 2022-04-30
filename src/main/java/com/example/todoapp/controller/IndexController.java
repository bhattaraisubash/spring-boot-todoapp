package com.example.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author subash
 * @since Apr 30, 2022
 */

@Controller
public class IndexController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String email, @RequestParam String password,
			RedirectAttributes redirectAttributes) {
		if (email.equals("admin@admin.com") && password.equals("password")) {
			return "redirect:/dashboard";
		}

		redirectAttributes.addAttribute("error", "Invalid email or password !");
		return "redirect:/";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout() {
		return "redirect:/";
	}

}
