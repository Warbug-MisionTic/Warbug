package com.misiontic.warbug.service.lmpl;

import com.misiontic.warbug.models.Employee;
import com.misiontic.warbug.models.Enterprise;
import com.misiontic.warbug.repository.IEmployeeRepository;
import com.misiontic.warbug.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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
        Employee enDB = repo.findById(id).get();

        if (Objects.nonNull(employee.getEmail()) && !"".equalsIgnoreCase(employee.getEmail())) {
            enDB.setEmail(employee.getEmail());
        }

        if (Objects.nonNull(employee.getPassword()) && !"".equalsIgnoreCase(employee.getPassword())) {
            enDB.setPassword(employee.getPassword());
        }

        if (Objects.nonNull(employee.getRole())) {
            enDB.setRole(employee.getRole());
        }


        enDB.setUpdatedAt(LocalDateTime.now());
        enDB.setCreatedAt(enDB.getCreatedAt());

        return repo.save(enDB);
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
