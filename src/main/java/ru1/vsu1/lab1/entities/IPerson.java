package ru1.vsu1.lab1.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import ru1.vsu1.lab1.entities.enums.Gender;

public interface IPerson {
	
	public Integer getId();
	
	public void setId(Integer id);
	
	public String getFirstName();
	
	public String setFirstName(String firstName);
	
	public String getLastName();
	
	public String setLastName(String lastName);
	
	public LocalDate getBirthday();
	
	public LocalDate setBirthday(LocalDate birthday);
	
	public Integer getAge();
	
	public Gender getGender();
	
	public void setGender(Gender gender);
	
	public IDivision getDivision();
	
	public void setDivision(IDivision division);
	
	public BigDecimal getSalary();
	
	public void setSalary(BigDecimal salary);
	
	

}
