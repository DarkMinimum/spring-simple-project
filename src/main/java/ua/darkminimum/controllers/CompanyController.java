package ua.darkminimum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.darkminimum.entities.Company;
import ua.darkminimum.services.CompanyService;

@Controller
@RequestMapping("/company/")
public class CompanyController {

    @Autowired
    CompanyService companies;

    @RequestMapping("/all")
    @ResponseBody
    public ModelAndView getAllCompanies(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("companies", companies.getAll());
        modelAndView.setViewName("indexAllCompanies.html");
        return modelAndView;
    }

    @RequestMapping("/get")
    @ResponseBody
    public ModelAndView getSingleCompany(@RequestParam String pk, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("company", companies.getCompany(pk));
        modelAndView.setViewName("indexOneCompany.html");
        return modelAndView;
    }

    @RequestMapping(path = "/new")
    public ModelAndView newCompany(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("company", new Company());
        modelAndView.setViewName("indexNewCompany.html");
        return modelAndView;
    }

    @RequestMapping("/sent")
    public ModelAndView saveEmployee(@ModelAttribute Company company, Model model) {
        Long pk = companies.add(company);

        return (pk > -1L) ? this.getSingleCompany(String.valueOf(pk), model) : this.showError(model);

    }

    ///TODO: Message for an error page
    @RequestMapping("/err")
    @ResponseBody
    public ModelAndView showError(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("indexErr.html");
        return modelAndView;
    }


}
