package de.m1well.spring.sample.webapp.service.impl;

import de.m1well.spring.sample.webapp.model.AppUser;
import de.m1well.spring.sample.webapp.repository.AppAuthorityRepository;
import de.m1well.spring.sample.webapp.repository.AppUserRepository;
import de.m1well.spring.sample.webapp.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

/**
 * author: Michael Wellner<br/>
 * date: 25.10.2017<br/>
 */
@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppAuthorityRepository appAuthorityRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(AppUser appUser) {
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        appUser.setRoles(new HashSet<>(appAuthorityRepository.findAll()));
        appUserRepository.save(appUser);
    }

    @Override
    public AppUser findByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}