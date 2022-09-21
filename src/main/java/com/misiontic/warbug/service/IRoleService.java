package com.misiontic.warbug.service;

import com.misiontic.warbug.models.Role;

import java.util.List;

public interface IRoleService {
    List<Role> readAll() throws Exception;
    Role readById(Long id) throws Exception;
}
