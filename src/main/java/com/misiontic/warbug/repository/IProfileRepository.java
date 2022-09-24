package com.misiontic.warbug.repository;


import com.misiontic.warbug.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfileRepository extends JpaRepository<Profile,Long> {

}
