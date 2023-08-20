package com.example.spring_app.controller;

import com.example.spring_app.model.employee.Employee;
import com.example.spring_app.model.employee.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employee/get-all")
    public List<Employee> getAllEmployees(){
        return employeeDao.getAllEmployees();

    }

    @DeleteMapping("/employee/delete/{key_word}")
    public void deleteByIdEmployee(@PathVariable("key_word") int id){
        employeeDao.deleteById(id);

    }


    @GetMapping(value = "/employee/get/{key_word}")
    public List<Employee> getEmployeesByKeyword(@PathVariable("key_word") String key_word){
        return employeeDao.getEmployeesByKeyword(key_word);
    }

    @PostMapping("/employee/save")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeDao.addEmployee(employee);
    }

}
