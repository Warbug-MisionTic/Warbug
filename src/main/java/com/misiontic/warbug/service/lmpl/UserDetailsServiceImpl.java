package com.misiontic.warbug.service.lmpl;


import com.misiontic.warbug.models.Employee;
import com.misiontic.warbug.models.Role;
import com.misiontic.warbug.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IEmployeeRepository userRepository;

    @Override
    @Transactional()
    public UserDetails loadUserByUsername(String email) {
        Employee user = userRepository.findByEmail(email);
        if (user == null) throw new UsernameNotFoundException(email);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRole()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }
}

