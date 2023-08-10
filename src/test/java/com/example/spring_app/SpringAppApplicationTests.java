package com.example.spring_app;

import com.example.spring_app.model.employee.Employee;
import com.example.spring_app.model.employee.EmployeeDao;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringAppApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void  addEmployeeTest(){
        Employee employee = new Employee();
        employee.setFIO("SecondTest");
        employee.setLocation("City-17");
        employee.setBranch("HQ");
        employeeDao.save(employee);

    }

//    @Test
    void getAllEmployees(){
        System.out.println(employeeDao.getAllEmployees());
    }

    @Test
    void getEmployeesByKeyword(){
        System.out.println(employeeDao.getEmployeesByKeyword("City-17"));
    }

//    @Test
    void getAllEmployeesAndDelete(){
        List<Employee> employees= employeeDao.getAllEmployees();
        for (Employee employee : employees) {
            employeeDao.delete(employee);
        }
    }

    //@Test
    void deleteEmployeeById(){
        employeeDao.deleteById(3);
    }

}
