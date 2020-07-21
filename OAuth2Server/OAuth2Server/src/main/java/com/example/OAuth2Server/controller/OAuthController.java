package com.example.OAuth2Server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthController {

	@GetMapping("/authcode")
	public String code(@RequestParam String code) {
		return code;
	}
}
