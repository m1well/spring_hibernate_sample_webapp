package de.m1well.spring.sample.webapp.service.impl;

import de.m1well.spring.sample.webapp.model.AppAuthority;
import de.m1well.spring.sample.webapp.model.AppUser;
import de.m1well.spring.sample.webapp.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * author: Michael Wellner<br/>
 * date: 25.10.2017<br/>
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(username);

        if (appUser == null) {
            throw new UsernameNotFoundException(username);
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (AppAuthority appAuthority : appUser.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(appAuthority.getName()));
        }

        return new User(appUser.getUsername(), appUser.getPassword(), grantedAuthorities);
    }
}