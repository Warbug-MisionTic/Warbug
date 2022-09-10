package com.misiontic.warbug.service.lmpl;

import com.misiontic.warbug.models.Enterprise;
import com.misiontic.warbug.models.Profile;
import com.misiontic.warbug.repository.IProfileRepository;
import com.misiontic.warbug.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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
        Profile enDB = repo.findById(id).get();

        if (Objects.nonNull(profile.getImage()) && !"".equalsIgnoreCase(profile.getImage())) {
            enDB.setImage(profile.getImage());
        }

        if (Objects.nonNull(profile.getPhone()) && !"".equalsIgnoreCase(profile.getPhone())) {
            enDB.setPhone(profile.getPhone());
        }

        enDB.setUpdatedAt(LocalDateTime.now());
        enDB.setCreatedAt(enDB.getCreatedAt());

        return repo.save(enDB);
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
