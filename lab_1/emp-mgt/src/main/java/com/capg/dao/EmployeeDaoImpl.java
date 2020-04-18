package com.capg.dao;

import com.capg.entities.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao{

    private Map<Integer,Employee>store=new HashMap<>();

    public EmployeeDaoImpl(){
        store.put(1,new Employee(100,"Shreya",30000));
        store.put(2,new Employee(101,"Ritu",40000));
    }

    @Override
    public Employee findById(int id)
    {
    	Employee employee = store.get(id);
    	return employee;
    	
    }
    @Override
    public List<Employee> fetchAllEmployees() {
        Collection<Employee>employees=store.values();
        List<Employee>list=new ArrayList<>(employees);
        return list;
    }
}
