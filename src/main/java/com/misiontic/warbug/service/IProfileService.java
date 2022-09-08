package com.misiontic.warbug.service;


import com.misiontic.warbug.models.Profile;

import java.util.List;

public interface IProfileService {
    Profile create(Profile profile) throws Exception;
    Profile update(Profile profile, Long id) throws Exception;
    List<Profile> readAll() throws Exception;
    Profile readById(Long id) throws Exception;
    void delete(Long id) throws Exception;

}
