package org.projects.em_project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmServiceImplement implements EmService{
    //IMPLEMENTING THE SERVICE LAYER WHERE WE CREATED  INTERFACE

    @Autowired
    private EmRepository emRepository;

    // List<Employee> employees = new ArrayList<>();
    @Override
    public String createEmployee(Employee employee) {
        EmEntity emEntity = new EmEntity();  //CREATING NEW OBJECT TO STORE IN DB
        BeanUtils.copyProperties(employee, emEntity); //COPYING PROPERTIES FROM EMPLOYEE TO EMENTITY

        emRepository.save(emEntity);  //STORING TO DB
        // employees.add(employee);  //STORES LOCALLY
        return "Saved Successfully"; 
    }



    @Override
    public List<Employee> readEmployee() {
        List<EmEntity> employeesList = emRepository.findAll();
        List<Employee> employees = new ArrayList<>();
        for (EmEntity emEntity : employeesList) {

            Employee emp = new Employee();   //OBJECT TO STORE DATA FROM DB
            emp.setId(emEntity.getId());
            emp.setName(emEntity.getName());
            emp.setEmail(emEntity.getEmail());
            emp.setPhone(emEntity.getPhone());

            employees.add(emp);
        }
        return employees;
    }



    //@Override
    // public boolean deleteEmployee(Long id) {
    //     employees.remove(id);
    //     return true;
    // }
    @Override

    public boolean deleteEmployee(Long id) {
    // for (int i = 0; i < employees.size(); i++) {
    //     if (employees.get(i).getId().equals(id)) {
    //         employees.remove(i);
    //         return true;
    //     }
    // }
    
    EmEntity emp = emRepository.findById(id).get();
    emRepository.delete(emp);
    return true;
    }



    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmEntity exisitingEmployee = emRepository.findById(id).get();
        exisitingEmployee.setName(employee.getName());
        exisitingEmployee.setEmail(employee.getEmail());
        exisitingEmployee.setPhone(employee.getPhone());

        emRepository.save(exisitingEmployee);    //SAVING UPDATED EMPLOYEE TO DB
        return "Updated Successfully";
    }


    @Override
    public Employee readEmployees(Long id) {
        EmEntity emEntity = emRepository.findById(id).get();
        Employee employee = new Employee();   
        BeanUtils.copyProperties(emEntity, employee); //COPYING PROPERTIES FROM EMENTITY TO EMPLOYEE

        return employee;
    }



    
}