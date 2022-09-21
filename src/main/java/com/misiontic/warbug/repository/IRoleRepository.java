package com.misiontic.warbug.repository;

import com.misiontic.warbug.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {
}
