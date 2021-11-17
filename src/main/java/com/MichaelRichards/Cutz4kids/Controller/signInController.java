package com.MichaelRichards.Cutz4kids.Controller;

import com.MichaelRichards.Cutz4kids.Model.User;
import com.MichaelRichards.Cutz4kids.Sevice.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping
public class signInController {


    public signInController() {
    }

    @Autowired
    private UserService userService;

    @Autowired
    public signInController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/loginForm")
    public String showLogInForm(Model theModel){

        theModel.addAttribute("user", new User());

        return "login";
    }


    @RequestMapping("/processSignInForm")
    public String processSignInForm(
            @Valid @ModelAttribute("user") User user,
            BindingResult theResult) {

        System.out.println(user);

        User temp  = userService.findUserByUsername(user.getUsername()).orElse(null);




        if(theResult.hasErrors()) {
            return "loginForm";
        }


        userService.save(user);

        return "registration-confirmation";
    }

    @GetMapping("/signUp")
    public String showSignupForm(Model model){

        User user = new User();

        model.addAttribute("user", user);
        return "signupForm";
    }

    @RequestMapping("processSignUpForm")
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
                model.addAttribute("", "Email already exists");
            }

            return "signUp";
        }





        if(theResult.hasErrors()) {
            return "loginForm";
        }
        else {
            userService.save(user);
            return "Customer-Confirmation";
        }
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token){
        return userService.confirmToken(token);
    }



}
