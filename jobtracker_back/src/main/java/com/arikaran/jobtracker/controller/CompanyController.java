package com.arikaran.jobtracker.controller;

import com.arikaran.jobtracker.entity.Company;
import com.arikaran.jobtracker.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@CrossOrigin(origins = "*")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyService.createCompany(company);
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable Long id) {
        return companyService.getCompanyById(id);
    }

    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable Long id,
                                 @RequestBody Company company) {
        return companyService.updateCompany(id, company);
    }

    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return "Company deleted successfully";
    }
}