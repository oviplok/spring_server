package com.example.spring_app.model.employee;

import com.example.spring_app.model.employee.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    @Query(value ="SELECT * FROM springserverdb.employee WHERE concat(fio, branch, location) LIKE concat('%',:query,'%')", nativeQuery = true)
    public List<Employee> findEmployeeByKeyword(@Param("query") String keyword);
}
