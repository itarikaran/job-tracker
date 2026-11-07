package com.arikaran.jobtracker.service;

import com.arikaran.jobtracker.entity.Company;
import com.arikaran.jobtracker.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));
    }

    public Company updateCompany(Long id, Company updatedCompany) {
        Company company = getCompanyById(id);

        company.setCompanyName(updatedCompany.getCompanyName());
        company.setDistrict(updatedCompany.getDistrict());
        company.setAddress(updatedCompany.getAddress());
        company.setStatus(updatedCompany.getStatus());
        company.setNotes(updatedCompany.getNotes());

        return companyRepository.save(company);
    }

    public void deleteCompany(Long id) {
        companyRepository.delete(getCompanyById(id));
    }
}