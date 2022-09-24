package com.misiontic.warbug.repository;


import com.misiontic.warbug.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Employee, Long> {
    Employee findByUsername(String username);
}
