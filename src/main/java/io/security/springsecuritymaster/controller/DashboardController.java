package io.security.springsecuritymaster.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
	@GetMapping(value="/")
	public String dashboard() {
		return "/dashboard";
	}

	@GetMapping(value="/user")
	public String user() {
		return "/user";
	}

	@GetMapping(value="/manager")
	public String manager() {
		return "/manager";
	}

	@GetMapping(value="/admin")
	public String admin() {
		return "/admin";
	}
}