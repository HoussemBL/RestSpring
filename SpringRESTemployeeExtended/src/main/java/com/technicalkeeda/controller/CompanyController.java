package com.technicalkeeda.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.technicalkeeda.bean.Company;
import com.technicalkeeda.bean.Employee;
import com.technicalkeeda.service.CompanyService;
import com.technicalkeeda.service.EmployeeService;
 

@RestController
public class CompanyController {
 
 @Autowired
 private CompanyService companyService;
 
 @RequestMapping(value = "/company", method = RequestMethod.GET, produces = "application/json")
 public ResponseEntity<List<Company>> companies() {
 
  HttpHeaders headers = new HttpHeaders();
  List<Company> companies = companyService.getCompanies();
 
  if (companies == null) {
   return new ResponseEntity<List<Company>>(HttpStatus.NOT_FOUND);
  }
  headers.add("Number Of Records Found", String.valueOf(companies.size()));
  return new ResponseEntity<List<Company>>(companies, headers, HttpStatus.OK);
 }
 
 
 
 @RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
 public ResponseEntity<Company> getEmployee(@PathVariable("id") Long companyId) {
  Company company = companyService.getCompany(companyId);
  if (company == null) {
   return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
  }
  return new ResponseEntity<Company>(company, HttpStatus.OK);
 }
 
 
 
 @RequestMapping(value = "/company/delete/{id}", method = RequestMethod.DELETE)
 public ResponseEntity<Company> deleteEmployee(@PathVariable("id") Long companyId) {
  HttpHeaders headers = new HttpHeaders();
  Company company = companyService.getCompany(companyId);
  if (company == null) {   
   return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
  }
  companyService.deleteCompany(companyId);
  headers.add("company Deleted - ", String.valueOf(companyId));
  return new ResponseEntity<Company>(company, headers, HttpStatus.NO_CONTENT);
 }
 
 
 
 @RequestMapping(value = "/company", method = RequestMethod.POST,produces = "application/json")
 public ResponseEntity<Company> createEmployee(@RequestBody Company company) {
  HttpHeaders headers = new HttpHeaders();
  if (company == null) {
   return new ResponseEntity<Company>(HttpStatus.BAD_REQUEST);
  }
  companyService.createCompany(company);
  headers.add("Company Created  - ", String.valueOf(company.getCompanyId()));
  return new ResponseEntity<Company>(company, headers, HttpStatus.CREATED);
 }
 
 @RequestMapping(value = "/company/{id}", method = RequestMethod.PUT)
 public ResponseEntity<Company> updateEmployee(@PathVariable("id") Long companyId, @RequestBody Company company) {
  HttpHeaders headers = new HttpHeaders();
   Company isExist = companyService.getCompany(companyId);
  if (isExist == null) {   
   return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
  } else if (company == null) {
   return new ResponseEntity<Company>(HttpStatus.BAD_REQUEST);
  }
  companyService.updateCompany(company);
  headers.add("company Updated  - ", String.valueOf(companyId));
  return new ResponseEntity<Company>(company, headers, HttpStatus.OK);
 }
 
 
 //ajouter fonction qui filter les companys selon leur secteur d activities
}