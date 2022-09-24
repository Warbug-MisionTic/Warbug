package com.misiontic.warbug.service.lmpl;

import com.misiontic.warbug.models.Employee;
import com.misiontic.warbug.repository.UserRepository;
import com.misiontic.warbug.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Employee user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public Employee findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

