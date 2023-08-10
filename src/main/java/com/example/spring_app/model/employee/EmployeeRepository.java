package com.example.spring_app.model.employee;

import com.example.spring_app.model.employee.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    @Query("SELECT p FROM Employee p WHERE CONCAT(p.FIO, p.branch, p.location) LIKE %?1%")
    public List<Employee> findEmployeeByKeyword(String keyword);
}
