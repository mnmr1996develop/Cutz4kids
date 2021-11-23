package com.MichaelRichards.Cutz4kids.Controller;

import com.MichaelRichards.Cutz4kids.Model.User;
import com.MichaelRichards.Cutz4kids.Sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping
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

        if(theResult.hasErrors()) {
            return "signUp";
        }


        if(tempUsername != null || tempEmail != null){
            if (tempUsername != null){
                model.addAttribute("usernameRegistrationError" , "User name already exists.");
            }
            if (tempEmail != null){
                model.addAttribute("emailRegistrationError", "Email already exists");
            }

            return "signupForm";
        }
        else {
            userService.save(user);
            return "Customer-Confirmation";
        }
    }

//    @GetMapping("/confirm")
//    public String confirm(@RequestParam("token") String token){
//        return userService.confirmToken(token);
//    }

}
