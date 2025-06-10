package org.projects.em_project;

import java.util.*;

//performing crud operations on employee data
//interface (just a blueprint) for the service layer
public interface EmService {
    String createEmployee(Employee employee);
    List<Employee> readEmployee();
    boolean deleteEmployee(Long id);
    String updateEmployee(Long id, Employee employee);
    Employee readEmployees(Long id); 
}
