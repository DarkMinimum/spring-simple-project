package ua.darkminimum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.darkminimum.entities.Company;
import ua.darkminimum.services.CompanyService;

import java.util.List;

@RestController
@RequestMapping("company")
public class CompanyController {

    @Autowired
    CompanyService companies;

    @RequestMapping("all/")
    public List<Company> getAllCompanies() {
        return companies.list();
    }

    @GetMapping("")
    @ResponseBody
    public Company getSingleCompany(@RequestParam String pk) {
        return companies.getCompany(pk);
    }

    @RequestMapping("/helloWorld")
    public String helloWorld() {
        return "helloWorld";
    }
}
