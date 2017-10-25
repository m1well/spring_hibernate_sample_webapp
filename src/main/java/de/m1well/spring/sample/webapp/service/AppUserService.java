package de.m1well.spring.sample.webapp.service;

import de.m1well.spring.sample.webapp.model.AppUser;

import java.util.List;

/**
 * author: Michael Wellner<br/>
 * date: 25.10.2017<br/>
 */
public interface AppUserService {

    void save(AppUser appUser);

    AppUser findByUsername(String username);

}