package com.wanted.wanted.company.service;

import com.wanted.wanted.company.entity.Company;
import com.wanted.wanted.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyService {
    private final CompanyRepository companyRepository;

    public Company getCompany(Long company_id) {
        Optional<Company> company = companyRepository.findById(company_id);
        return company.get();
    }
}
