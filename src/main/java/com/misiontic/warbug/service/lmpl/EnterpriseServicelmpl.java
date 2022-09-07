package com.misiontic.warbug.service.lmpl;

import com.misiontic.warbug.models.Enterprise;
import com.misiontic.warbug.repository.IEnterpriseRepository;
import com.misiontic.warbug.service.IEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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

        if (Objects.nonNull(enterprise.getName()) && !"".equalsIgnoreCase(enterprise.getName())) {
            enDB.setName(enterprise.getName());
        }

        if (Objects.nonNull(enterprise.getDocument()) && !"".equalsIgnoreCase(enterprise.getDocument())) {
            enDB.setDocument(enterprise.getDocument());
        }

        if (Objects.nonNull(enterprise.getPhone()) && !"".equalsIgnoreCase(enterprise.getPhone())) {
            enDB.setPhone(enterprise.getPhone());
        }

        if (Objects.nonNull(enterprise.getAddress()) && !"".equalsIgnoreCase(enterprise.getAddress())) {
            enDB.setAddress(enterprise.getAddress());
        }
        enDB.setUpdatedAt(LocalDateTime.now());
        enDB.setCreatedAt(enDB.getCreatedAt());

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
