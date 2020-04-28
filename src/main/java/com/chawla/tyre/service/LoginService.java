package com.chawla.tyre.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.chawla.tyre.model.Login;
import com.chawla.tyre.utility.Constants;
import com.chawla.tyre.utility.Utility;

@Service
@PropertySource("classpath:config.properties")
public class LoginService {

	@Autowired
	Environment env;

	@Autowired
	Utility utility;

	public boolean validateLogin(Login login) {
		boolean isValid = false;
		String usernameHash = utility.generateMD5(login.getUsername());
		String passwordHash = utility.generateMD5(login.getPassword());
		if (usernameHash.equals(env.getProperty(Constants.LOGIN_USERNAME))
				&& passwordHash.equals(env.getProperty(Constants.LOGIN_PASSWORD))) {
			isValid = true;
		}
		return isValid;
	}
}
