package de.m1well.spring.sample.webapp.validation;

import de.m1well.spring.sample.webapp.model.AppUser;
import de.m1well.spring.sample.webapp.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * author: Michael Wellner<br/>
 * date: 25.10.2017<br/>
 */
@Component
public class AppUserValidator implements Validator {

    @Autowired
    private AppUserService appUserService;

    @Override
    public boolean supports(Class<?> aClass) {
        return AppUser.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        AppUser appUser = (AppUser) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (appUser.getUsername().length() < 6 || appUser.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (appUserService.findByUsername(appUser.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (appUser.getPassword().length() < 8 || appUser.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!appUser.getPasswordConfirm().equals(appUser.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}