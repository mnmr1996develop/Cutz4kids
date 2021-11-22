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
public class LogInController {


    public LogInController() {
    }

    @Autowired
    private UserService userService;



    @Autowired
    public LogInController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/loginForm")
    public String showLogInForm(Model theModel){

        theModel.addAttribute("user", new User());

        return "login";
    }




}
