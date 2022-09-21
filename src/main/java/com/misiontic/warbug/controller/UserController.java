package com.misiontic.warbug.controller;

import com.misiontic.warbug.models.Employee;
import com.misiontic.warbug.models.Enterprise;
import com.misiontic.warbug.service.IEnterpriseService;
import com.misiontic.warbug.service.SecurityService;
import com.misiontic.warbug.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private IEnterpriseService Eservice;
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        if (securityService.isAuthenticated()) {
            return "redirect:/employees";
        }

        model.addAttribute("userForm", new Employee());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") Employee userForm, BindingResult bindingResult) throws Exception {
        userValidator.validate(userForm, bindingResult);


        if (bindingResult.hasErrors()) {
            return "registration";
        }

        Enterprise enterprice = Eservice.readById(1l);
        userForm.setEnterprise(enterprice);
        userForm.setName("Holaaa");

        userService.save(userForm);

        return "redirect:/employees";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (securityService.isAuthenticated()) {
            return "redirect:/employees";
        }

        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }


}
