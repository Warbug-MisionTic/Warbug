package com.misiontic.warbug.service.lmpl;

import com.misiontic.warbug.models.Profile;
import com.misiontic.warbug.repository.IProfileRepository;
import com.misiontic.warbug.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements IProfileService {
    @Autowired
    private IProfileRepository repo;


    @Override
    public Profile create(Profile profile) throws Exception {
        return repo.save(profile);
    }

    @Override
    public Profile update(Profile profile, Long id) throws Exception {
        return null;
    }

    @Override
    public List<Profile> readAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Profile readById(Long id) throws Exception {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) throws Exception {
        repo.deleteById(id);
    }
}
