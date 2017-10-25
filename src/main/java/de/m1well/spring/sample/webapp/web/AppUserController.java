package de.m1well.spring.sample.webapp.web;

import de.m1well.spring.sample.webapp.model.AppUser;
import de.m1well.spring.sample.webapp.service.AppUserService;
import de.m1well.spring.sample.webapp.service.SecurityService;
import de.m1well.spring.sample.webapp.validation.AppUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * author: Michael Wellner<br/>
 * date: 25.10.2017<br/>
 */
@Controller
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private AppUserValidator appUserValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new AppUser());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") AppUser userForm, BindingResult bindingResult, Model model) {
        appUserValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        appUserService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
}