package com.misiontic.warbug.service;

import com.misiontic.warbug.models.Employee;

public interface UserService {
    void save(Employee user);

    Employee findByUsername(String username);
}
