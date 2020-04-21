package com.cg;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.cg")
@PropertySource("classpath:employee.properties")
public class JavaConfig {
	
	@Bean
	public SBU sbu()
	{
		Employee employee1 = new Employee();
		employee1.setEmployeeId(12345);
		employee1.setEmployeeName("Harriet");
		employee1.setAge(30);
		employee1.setSalary(40000);
		
		Employee employee2 = new Employee();
		employee2.setEmployeeId(12346);
		employee2.setEmployeeName("Shreya");
		employee2.setAge(21);
		employee2.setSalary(45000);
	
		List<Employee> empList = new ArrayList<>();
		empList.add(employee1);
		empList.add(employee2);
		SBU sbu = new SBU();
		sbu.setEmpList(empList);
		return sbu;
		
	}
	

}
