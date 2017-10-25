package de.m1well.spring.sample.webapp.service;

/**
 * author: Michael Wellner<br/>
 * date: 25.10.2017<br/>
 */
public interface SecurityService {

    String findLoggedInUsername();

    void autologin(String username, String password);

}
