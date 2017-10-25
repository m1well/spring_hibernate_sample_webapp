package de.m1well.spring.sample.webapp.model;

import javax.persistence.*;
import java.util.Set;

/**
 * author: Michael Wellner<br/>
 * date: 25.10.2017<br/>
 */
@Entity
@Table(name = "role")
public class AppAuthority {
    private Long id;
    private String name;
    private Set<AppUser> users;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<AppUser> getUsers() {
        return users;
    }

    public void setUsers(Set<AppUser> users) {
        this.users = users;
    }
}
