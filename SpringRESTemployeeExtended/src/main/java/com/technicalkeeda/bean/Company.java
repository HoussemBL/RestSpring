package com.technicalkeeda.bean;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {
	 private Long companyId;
	 private String companyName;
	 private String sector;
	 private String adresse;
	  
	 
	 
	 
	 @JsonCreator 
	public Company(@JsonProperty("companyId")Long companyId,@JsonProperty("companyName") String companyName,@JsonProperty("sector") String sector,@JsonProperty("adresse") String adresse) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.sector = sector;
		this.adresse = adresse;
	}


	public Company() {
		
	}


	public Long getCompanyId() {
		return companyId;
	}


	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getSector() {
		return sector;
	}


	public void setSector(String sector) {
		this.sector = sector;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	 
	 
	 @Override
	 public String toString() {
	  StringBuilder str = new StringBuilder();
	  str.append("company Id:- " + getCompanyId());
	  str.append(" company Name:- " + getCompanyName());
	  str.append(" sector:- " + getSector());
	  str.append(" Adresse:- " + getAdresse());
	  return str.toString();
	 } 
	 
	 
}
