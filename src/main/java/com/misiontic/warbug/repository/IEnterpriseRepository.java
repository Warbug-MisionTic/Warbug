package com.misiontic.warbug.repository;

import com.misiontic.warbug.models.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnterpriseRepository extends JpaRepository<Enterprise,Long> {
}
