package com.misiontic.warbug.service;

import com.misiontic.warbug.models.Employee;
import com.misiontic.warbug.models.EmployeeProfile;
import com.misiontic.warbug.models.Enterprise;

import java.util.List;

public interface IEmployeeService {

    Employee create(Employee employee) throws Exception;
    Employee update(Employee employee, Long id) throws Exception;
    List<Employee> readAll() throws Exception;
    Employee readById(Long id) throws Exception;
    void delete(Long id) throws Exception;

    List<EmployeeProfile> readAllEmployee();

    Employee findByEmail(String email);

}
