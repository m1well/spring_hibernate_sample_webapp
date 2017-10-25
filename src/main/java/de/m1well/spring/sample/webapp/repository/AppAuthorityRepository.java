package de.m1well.spring.sample.webapp.repository;

import de.m1well.spring.sample.webapp.model.AppAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: Michael Wellner<br/>
 * date: 25.10.2017<br/>
 */
public interface AppAuthorityRepository extends JpaRepository<AppAuthority, String>{
}
