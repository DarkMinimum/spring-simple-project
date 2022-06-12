package ua.darkminimum.services;

import antlr.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.darkminimum.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.darkminimum.entities.Company;
import ua.darkminimum.repos.CompanyRepo;

import java.util.List;
import java.util.Optional;


@Service
public class CompanyService {

    Logger logger = LoggerFactory.getLogger(CompanyService.class);
    private final String NOT_FOUND_SINGLE_COMPANY = "Company with id %s can't be found";
    private final String NOT_FOUND_COMPANIES = "There are no companies";

    @Autowired
    private CompanyRepo companyRepo;

    public List<Company> list() {
        return !companyRepo.findAll().isEmpty() ? companyRepo.findAll() : validateOutput();
    }

    public Company getCompany(final String pk) {
        Optional<Company> company;
        long pkParsed = Long.parseLong(pk);
        company = companyRepo.findById(pkParsed);

        return company.orElse(validateOutput(pk));
    }

    //TODO:Better error handling
    private Company validateOutput(final String pk) {
        logger.error(String.format(NOT_FOUND_SINGLE_COMPANY, pk));
        throw new NotFoundException();
    }

    private List<Company> validateOutput() {
        logger.error(NOT_FOUND_COMPANIES);
        throw new NotFoundException();
    }
}
