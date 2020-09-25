package com.technicalkeeda.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalkeeda.bean.Company;
import com.technicalkeeda.bean.Employee;
import com.technicalkeeda.dao.CompanyDao;
import com.technicalkeeda.dao.EmployeeDao;
 
@Service("companyService")
public class CompanyServiceImpl implements CompanyService {
 @Autowired
 private CompanyDao companyDao;
 

	public List<Company> getCompanies() {
		  List<Company> companies = companyDao.getCompanies();
		  return companies;
	}
 
 public Company getCompany(Long companyId) {
   Company company = companyDao.getCompany(companyId);
  return company;
 }
 
 public int deleteCompany(Long companyId) {
  return companyDao.deleteCompany(companyId);
 }
 
 public int updateCompany(Company company) {
  return companyDao.updateCompany(company);
 }
 
 public int createCompany(Company company) {
  return companyDao.createCompany(company);
 }
}