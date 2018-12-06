package com.luv2code.springsecurity.demo.controller;

import com.luv2code.springsecurity.demo.service.UserService;
import com.luv2code.springsecurity.demo.user.CrmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by admin on 06.12.2018.
 */
@Controller
@RequestMapping("/register")
public class RegistrationController {
    @Autowired
    UserService userService;
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,trimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showForm(Model model){
        CrmUser user = new CrmUser();
        model.addAttribute("crmUser",user);
        return "registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processForm(@Valid @ModelAttribute("crmUser") CrmUser theuser,
                              BindingResult theBindingResult,
                              Model model){
        if(theBindingResult.hasErrors())
            return "registration-form";
        if(userService.findByUserName(theuser.getName())!=null){
            model.addAttribute("crmUser", new CrmUser());
            model.addAttribute("registartionError", "User Name already exist");
            return "registration-form";
        }
        userService.save(theuser);
        return "registration-confirmation";
    }
}
