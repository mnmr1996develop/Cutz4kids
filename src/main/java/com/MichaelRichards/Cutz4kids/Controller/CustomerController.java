package com.MichaelRichards.Cutz4kids.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class CustomerController {

    @GetMapping("/ContactUs")
    public String showContactForm(){
        return "ContactUs";
    }

    @GetMapping("/Locations")
    public String showSingle(){
        return "locations";
    }

    @GetMapping("/Appointments")
    public String showAppointmentPage(){
        return "appointments";
    }

}
