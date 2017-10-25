package de.m1well.spring.sample.webapp.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * author: Michael Wellner<br/>
 * date: 25.10.2017<br/>
 */
public class SecurityInitializer
        extends AbstractSecurityWebApplicationInitializer {

    public SecurityInitializer() {
        super(SecurityConfig.class);
    }
}