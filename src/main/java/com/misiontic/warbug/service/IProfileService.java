package com.misiontic.warbug.service;


import com.misiontic.warbug.models.Employee;
import com.misiontic.warbug.models.EmployeeProfile;
import com.misiontic.warbug.models.Profile;

import java.util.List;

public interface IProfileService {
    Profile create(Profile profile) throws Exception;
    Profile update(Profile profile, Long id) throws Exception;
    List<Profile> readAll() throws Exception;
    Profile readById(Long id) throws Exception;
    void delete(Long id) throws Exception;
    Profile profileByEmployee(Employee employee);

}
