package com.chawla.tyre.model;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class Login {
	@NotBlank(message = "username should not be blank")
	private String username;
	@NotBlank(message = "password should not be blank")
	private String password;
}
