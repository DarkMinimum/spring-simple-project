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
    private final String MODEL_NOT_SAVED = "The company model wasn't saved due to exceptions";

    @Autowired
    private CompanyRepo companyRepo;

    //ToDO: paggination
    public List<Company> getAll() {
        return !companyRepo.findAll().isEmpty() ? companyRepo.findAll() : (List<Company>) validateOutput("");
    }

    public Company getCompany(final String pk) {
        Optional<Company> company;
        long pkParsed = Long.parseLong(pk);
        company = companyRepo.findById(pkParsed);

        return company.isPresent() ? company.get() : (Company) validateOutput(pk);
    }

    public Long add(final Company company) {
        Long result = -1L;

        try {
            companyRepo.save(company);
            result = companyRepo.findCompanyByName(company.getName()).getPk();
        } catch (Exception exception) {
            logger.error(MODEL_NOT_SAVED);
        }

        return result;
    }

    //TODO:Better error handling
    private Object validateOutput(final String pk) {
        logger.error(String.format(NOT_FOUND_SINGLE_COMPANY, pk));
        throw new NotFoundException();
    }
}
