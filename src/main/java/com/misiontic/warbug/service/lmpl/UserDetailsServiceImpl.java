package com.misiontic.warbug.service.lmpl;


import com.misiontic.warbug.models.Employee;
import com.misiontic.warbug.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional()
    public UserDetails loadUserByUsername(String username) {
        Employee user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException(username);

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("Admin"));
        roles.add(new SimpleGrantedAuthority("User"));

        UserDetails userDet = new User(user.getUsername(), user.getPassword(),roles);
        return userDet;
        }
}


