package com.MichaelRichards.Cutz4kids.Controller;

import com.MichaelRichards.Cutz4kids.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class CustomerController {

    @GetMapping("/ContactUs")
    public String showLogInForm(){


        return "contact";
    }

}
