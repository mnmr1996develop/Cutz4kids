package com.MichaelRichards.Cutz4kids.Controller;

import com.MichaelRichards.Cutz4kids.Model.User;
import com.MichaelRichards.Cutz4kids.Sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping
public class signInController {

    @Autowired
    private UserService userService;

    @Autowired
    public signInController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/loginForm")
    public String showLogInForm(){
        return "login";
    }

    @GetMapping("/signUp")
    public String showSignupForm(Model model){

        User user = new User();

        model.addAttribute("user", user);
        return "signupForm";
    }

    @RequestMapping("user/processSignUpForm")
    public String processForm(
            @ModelAttribute("user") User user,
            BindingResult theResult) {

        System.out.println(user);

        if(theResult.hasErrors()) {
            return "loginForm";
        }
        else {
            userService.save(user);
            return "Customer-Confirmation";
        }
    }


}
