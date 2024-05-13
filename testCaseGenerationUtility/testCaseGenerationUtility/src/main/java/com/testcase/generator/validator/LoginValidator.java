package com.testcase.generator.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.testcase.generator.model.UserLoginTest;
import com.testcase.generator.service.UserService;

public class LoginValidator implements Validator {

	@Autowired
	private UserService userService;
	
	@Override
	public boolean supports(Class<?> aClass) {
		return UserLoginTest.class.equals(aClass);
	}

	@Override
	public void validate(Object obj, Errors err) {
		
		UserLoginTest user=(UserLoginTest) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "username", "NotEmpty");
        if (user.getUserName().length() < 6 || user.getUserName().length() > 32) {
        	err.rejectValue("username", "Size.userForm.username");
        }
        if (userService.findByUsername(user.getUserName()) != null) {
            err.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(err, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
        	err.rejectValue("password", "Size.userForm.password");
        }

       /* if (!user.getPasswordConfirm().equals(user.getPassword())) {
        	err.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }*/

		
	}

}
