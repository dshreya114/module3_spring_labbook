package com.cg;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class EmployeeMain {

    public static void main(String[] args) {
      

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
  
        Class configurationClass=JavaConfig.class;
        context.register(configurationClass);
        context.refresh();
        
        Employee employee = context.getBean(Employee.class);
        
        SBU sbu = employee.getSbuDetails();
        EmployeeMain object = new EmployeeMain();
        object.sbudetails(sbu);
       employee.displayEmployees();
        
     }
    
    public void sbudetails(SBU sbu)
    {
    	System.out.println("SBU Details : ");
    	System.out.println("sbuCode = "+sbu.getSbuId()+", sbuHead= "+sbu.getSbuHead()+", sbuName= "+sbu.getSbuName());
    }
}