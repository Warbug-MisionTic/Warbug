package com.misiontic.warbug.service.lmpl;

import com.misiontic.warbug.models.Role;
import com.misiontic.warbug.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleService repo;

    @Override
    public List<Role> readAll() throws Exception {
        return repo.readAll();
    }

    @Override
    public Role readById(Long id) throws Exception {
        return repo.readById(id);
    }
}
