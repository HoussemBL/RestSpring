package com.technicalkeeda.dao;

import java.util.List;

import com.technicalkeeda.bean.Company;

public interface CompanyDao {

	public List<Company> getCompanies() ;
	public Company getCompany(Long company_id) ;
	public int deleteCompany(Long company_id) ;
	public int updateCompany(Company company);
	public int createCompany(Company company);
	
	
	
	
}
