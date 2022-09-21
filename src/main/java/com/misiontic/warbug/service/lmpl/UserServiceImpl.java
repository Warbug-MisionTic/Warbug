package com.misiontic.warbug.service.lmpl;

import com.misiontic.warbug.models.Employee;
import com.misiontic.warbug.repository.IEmployeeRepository;
import com.misiontic.warbug.repository.IRoleRepository;
import com.misiontic.warbug.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private IEmployeeRepository userRepository;
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Employee user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public Employee findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

