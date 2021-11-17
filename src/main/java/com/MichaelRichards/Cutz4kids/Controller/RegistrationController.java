package com.MichaelRichards.Cutz4kids.Controller;

import com.MichaelRichards.Cutz4kids.Model.User;
import com.MichaelRichards.Cutz4kids.Sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/signUp")
    public String showSignupForm(Model model){

        User user = new User();

        model.addAttribute("user", user);
        return "signupForm";
    }

    @PostMapping("/processSignUpForm")
    public String processSignUpForm(
            @Valid @ModelAttribute("user") User user,
            BindingResult theResult,
            Model model) {

        User tempUsername = userService.findUserByUsername(user.getUsername()).orElse(null);
        User tempEmail = userService.findUserByEmail(user.getEmail()).orElse(null);

        System.out.println(tempUsername);


        if(tempUsername != null || tempEmail != null){
            model.addAttribute("User", new User());
            if (tempUsername != null){
                model.addAttribute("registrationError", "User name already exists.");
            }
            if (tempEmail != null){
                model.addAttribute("registrationError", "Email already exists");
            }

            return "signupForm";
        }





        if(theResult.hasErrors()) {
            return "signUp";
        }
        else {
            userService.save(user);
            return "Customer-Confirmation";
        }
    }
}
