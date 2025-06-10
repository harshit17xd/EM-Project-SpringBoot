package org.projects.em_project;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class EmController {

    //List<Employee> employees = new ArrayList<>();

    //EmService emService = new EmServiceImplement();     //OBJECT OF SERVICE LAYER
    //Dependency Injection
    @Autowired
    EmService emService;    //MAKE AUTO OBJECT WITH HELP OF IOC

    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        // Employee emp1 = new Employee();
        // emp1.setName("Harshit"); 
        // employees.add(null);
        // employees.add(emp1);

        return emService.readEmployee();
        //return employees;
    }

    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) {
        //employees.add(employee);  //IT WILL BE DONE BY SERVICE LAYER(ITS NOT CONTROLLER'S WORK)
        emService.createEmployee(employee);
        return "Saved Successfully";
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id){
        if(emService.deleteEmployee(id)) {
            return "Deleted Successfully";
        }
        return "Employee Not Found";
    }
}
