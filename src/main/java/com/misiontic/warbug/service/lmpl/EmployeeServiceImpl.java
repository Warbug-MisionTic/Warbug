package com.misiontic.warbug.service.lmpl;

import com.misiontic.warbug.models.Employee;
import com.misiontic.warbug.repository.IEmployeeRepository;
import com.misiontic.warbug.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository repo;

    @Override
    public Employee create(Employee employee) throws Exception {
        return repo.save(employee);
    }

    @Override
    public Employee update(Employee employee, Long id) throws Exception {
        return null;
    }

    @Override
    public List<Employee> readAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Employee readById(Long id) throws Exception {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) throws Exception {
        repo.deleteById(id);
    }
}
