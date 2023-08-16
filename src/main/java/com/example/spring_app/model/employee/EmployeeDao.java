package com.example.spring_app.model.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeDao {

    @Autowired
    private EmployeeRepository repository;


    public List<Employee> getEmployeesByKeyword(String keyword){
        //return repository.findAll();
        List<Employee> employees = new ArrayList<>();
        Streamable.of(repository.findEmployeeByKeyword(keyword)).forEach(employees::add );
        return employees;
    }

    public Employee addEmployee(Employee employee){
        return repository.save(employee);
    }

    public void deleteEmployee(Employee employee){
        repository.delete(employee);
    }

    public void deleteById(int id){
        repository.deleteById(id);
    }



    public List<Employee> getAllEmployees(){
        //return repository.findAll();
        List<Employee> employees = new ArrayList<>();
        Streamable.of(repository.findAll()).forEach(employees::add );
        return employees;
    }

}
