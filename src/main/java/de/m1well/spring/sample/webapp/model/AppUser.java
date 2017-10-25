package de.m1well.spring.sample.webapp.model;

import javax.persistence.*;
import java.util.Set;

/**
 * author: Michael Wellner<br/>
 * date: 25.10.2017<br/>
 */
@Entity
@Table(name = "user")
public class AppUser {

    private Long id;
    private String username;
    private String password;
    private String passwordConfirm;
    private Set<AppAuthority> roles;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<AppAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Set<AppAuthority> roles) {
        this.roles = roles;
    }
}
