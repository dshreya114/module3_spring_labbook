package com.cg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("employee")
public class Employee   {

    @Value("${employeeId}")
    private int employeeId;
    
    @Value("${employeeName}")
    private String employeeName;
    
    @Value("${salary}")
    private double salary;
    
    @Value("${businessUnit}")
    private String businessUnit;
    
    @Value("${age}")
    private int age;

    private SBU sbu;
	
    public SBU getSbu() {
 		return sbu;
 	}

    @Autowired
 	public void setSbu(SBU sbu) {
 		this.sbu = sbu;
 	}

    public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

public SBU getSbuDetails()
   {
	   SBU sbu = new SBU();
	   sbu.setSbuId("PES-BU");
	   sbu.setSbuHead("Kiran Rao");
	   sbu.setSbuName("Product Engineering Services");
	   return sbu;
   }

public void displayEmployee()
{
	System.out.println("Employee Details :");
	System.out.println("Employee "+"["+"empAge= "+age+" , empId = "+employeeId+", empName= "+employeeName+", empSalary= "+salary);
}
   
}
