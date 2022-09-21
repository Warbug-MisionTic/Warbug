package com.misiontic.warbug.service.lmpl;

import com.misiontic.warbug.models.Employee;
import com.misiontic.warbug.models.EmployeeProfile;
import com.misiontic.warbug.models.Profile;
import com.misiontic.warbug.repository.IEmployeeRepository;
import com.misiontic.warbug.repository.IRoleRepository;
import com.misiontic.warbug.service.IEmployeeService;
import com.misiontic.warbug.service.IProfileService;
import com.misiontic.warbug.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository repo;
    @Autowired
    private IProfileService pro;

    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Employee create(Employee employee) throws Exception {
        employee.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
        employee.setRole(new HashSet<>(roleRepository.findAll()));
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

    @Override
    public List<EmployeeProfile> readAllEmployee (){
        List<EmployeeProfile> employeeProfiles = new ArrayList<>();
        List<Employee> employees =  repo.findAll();
        for(Employee emp: employees){
            EmployeeProfile employe = new EmployeeProfile();
            Profile profile = pro.profileByEmployee(emp);
            employe.setId(emp.getIdEmployee());
            employe.setPhone(profile.getPhone());
            employe.setName(emp.getName());
            employe.setEmail(emp.getEmail());
            employeeProfiles.add(employe);
        }
        return employeeProfiles;
    }

}
