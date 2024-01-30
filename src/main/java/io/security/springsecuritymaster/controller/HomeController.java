package io.security.springsecuritymaster.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
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

	@GetMapping(value="/api")
	public String restDashboard() {
		return "rest/dashboard";
	}

	@GetMapping(value="/api/user")
	public String restUser() {
		return "rest/user";
	}

	@GetMapping(value="/api/manager")
	public String restManager() {
		return "rest/manager";
	}

	@GetMapping(value="/api/admin")
	public String restAdmin() {
		return "rest/admin";
	}
}