package com.misiontic.warbug.service.lmpl;

import com.misiontic.warbug.models.Employee;
import com.misiontic.warbug.models.Profile;
import com.misiontic.warbug.models.Role;
import com.misiontic.warbug.repository.IEmployeeRepository;
import com.misiontic.warbug.repository.IProfileRepository;
import com.misiontic.warbug.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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

    @Override
    public Profile profileByEmployee(Employee employee){
        List<Profile> profiles  = repo.findAll();
        Profile employeeProfile  =  new Profile();
         for(Profile pro: profiles){
           if(pro.getEmployee() == employee){
               employeeProfile.setPhone(pro.getPhone());
            }
        }
        return employeeProfile;
    }
}
