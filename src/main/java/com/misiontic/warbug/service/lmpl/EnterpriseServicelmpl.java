package com.misiontic.warbug.service.lmpl;

import com.misiontic.warbug.models.Enterprise;
import com.misiontic.warbug.repository.IEnterpriseRepository;
import com.misiontic.warbug.service.IEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseServicelmpl implements IEnterpriseService {

    @Autowired
    private IEnterpriseRepository repo;


    @Override
    public Enterprise create(Enterprise enterprise) throws Exception {
        return repo.save(enterprise);
    }

    @Override
    public Enterprise update(Enterprise enterprise, Long id) throws Exception {
        Enterprise enDB = repo.findById(id).get();
        enDB.setName(enterprise.getName());
        return repo.save(enDB);
    }

    @Override
    public List<Enterprise> readAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Enterprise readById(Long id) throws Exception {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) throws Exception {
            repo.deleteById(id);
    }
}
