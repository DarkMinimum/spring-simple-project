package ua.darkminimum.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @RequestMapping("/helloWorld")
    public String helloWorld() {
        return "helloWorld";
    }
}
