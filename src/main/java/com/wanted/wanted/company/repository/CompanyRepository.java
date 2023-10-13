package com.wanted.wanted.company.repository;

import com.wanted.wanted.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
