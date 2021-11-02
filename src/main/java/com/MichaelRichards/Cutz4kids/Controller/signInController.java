package com.MichaelRichards.Cutz4kids.Controller;

import com.MichaelRichards.Cutz4kids.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping
public class signInController {

    @GetMapping("/loginForm")
    public String showLogInForm(){
        return "login";
    }

    @GetMapping("/signUp")
    public String showSignupForm(){
        return "signupForm";
    }

    @RequestMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") User user,
            BindingResult theResult) {

        System.out.println(user);

        if(theResult.hasErrors()) {
            return "customer-form";
        }
        else {
            return "Customer-Confirmation";
        }
    }

}
