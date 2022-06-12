package ua.darkminimum.services;

import antlr.StringUtils;
import ua.darkminimum.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.darkminimum.entities.Company;
import ua.darkminimum.repos.CompanyRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final String NOT_FOUND = "Company with id {%s} can't be found";

    @Autowired
    private CompanyRepo companyRepo;

    public List<Company> list() {
        return companyRepo.findAll();
    }

    public Company getCompany(final String pk) {

        Optional<Company> company;
        long pkParsed = Long.parseLong(pk);
        company = companyRepo.findById(pkParsed);

        return company.orElse(null);
    }
}
