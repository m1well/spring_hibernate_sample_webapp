package de.m1well.spring.sample.webapp.repository;

import de.m1well.spring.sample.webapp.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: Michael Wellner<br/>
 * date: 25.10.2017<br/>
 */
public interface AppUserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUsername(String username);
}