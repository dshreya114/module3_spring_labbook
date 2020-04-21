package com.capg;

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

   public void display()
{
	System.out.println("Employee details :");
	System.out.println("Employee ID : "+employeeId);
	System.out.println("Employee Name : "+employeeName);
	System.out.println("Employee salary : "+salary);
	System.out.println("Employee BU : "+businessUnit);
	System.out.println("Employee age : "+age);
}
   
}
