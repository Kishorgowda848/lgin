package com.app;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* this is the test controller*/
@RestController
public class RequestRestController {

	@GetMapping("/")
	public String All() {
		return "Wellcome  ALl";
	}

	@GetMapping("/user")
	public String user() {
		return "Wellcome user";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/admin")
	public String admin() {
		return "Wellcome admin";
	}

	@RequestMapping("/loginpage")
	public String call() {
		return "vueee.jsp";
	}
}
