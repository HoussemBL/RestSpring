package com.technicalkeeda.service;

import java.util.List;

import com.technicalkeeda.bean.Company;
import com.technicalkeeda.bean.Employee;

public interface CompanyService {

	public List<Company> getCompanies();
	public Company getCompany(Long companyId);
	 public int deleteCompany(Long companyId);
	 public int updateCompany(Company company);
	 public int createCompany(Company company); 

}
