package com.technicalkeeda.dao;
 
import java.util.List;
 
import javax.sql.DataSource;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.technicalkeeda.bean.Company;
import com.technicalkeeda.bean.Employee;
 
@Repository("companyDao")
public class CompanyDaoImpl implements CompanyDao {
 
 private JdbcTemplate jdbcTemplate;
 
 @Autowired
 public void setDataSource(DataSource dataSource) {
  this.jdbcTemplate = new JdbcTemplate(dataSource);
 }
 
 public List<Company> getCompanies() {
  List<Company> companies = null ;
  
  try {
   companies = jdbcTemplate.query("SELECT * FROM trn_company",new BeanPropertyRowMapper<Company>(Company.class));   
  } catch (DataAccessException e) {
   e.printStackTrace();
  }
  return companies;
 }
 
 public Company getCompany(Long companyId) {
  Company company = null;
  try {
   company = jdbcTemplate.queryForObject("SELECT * FROM trn_company WHERE company_id = ?",
     new Object[] { companyId }, new BeanPropertyRowMapper<Company>(Company.class));
  } catch (DataAccessException e) {
   e.printStackTrace();
  }
  return company;
 
 }
 
 public int deleteCompany(Long companyId) {
  int count = jdbcTemplate.update("DELETE from trn_company WHERE company_id = ?", new Object[] { companyId });
  return count;
 }
 
 public int updateCompany(Company company) {
  int count = jdbcTemplate.update(
    "UPDATE trn_company set company_name = ? , sector = ? , adresse = ? where company_id = ?", new Object[] {
      company.getCompanyName(), company.getSector(), company.getAdresse(), company.getCompanyId() });
  return count;
 }
 
 public int createCompany(Company company) {
  int count = jdbcTemplate.update(
    "INSERT INTO trn_company(company_id,company_name, sector, adresse)VALUES(?,?,?,?)", new Object[] {
    		company.getCompanyId(), company.getCompanyName(), company.getSector(), company.getAdresse() });
  return count;
 }
 
}