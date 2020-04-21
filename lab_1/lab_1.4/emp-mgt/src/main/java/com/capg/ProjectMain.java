package com.capg;

import com.capg.config.JavaConfig;
import com.capg.entities.Employee;
import com.capg.service.IEmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class ProjectMain {

    public static void main(String[] args) {
      
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
       
        Class configurationClass= JavaConfig.class;
        context.register(configurationClass);
        context.refresh();
        context.registerShutdownHook();
        
        
        IEmployeeService service = context.getBean(IEmployeeService.class);
        
        /**
        List<Employee>employees= service.fetchAllEmployees();
        for (Employee e :employees){
            System.out.println(e.getId()+", "+e.getName()+", "+e.getSalary());
        }
        **/
    }


}