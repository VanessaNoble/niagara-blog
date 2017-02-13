package com.codeup.models;

import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vanessamnoble on 2/10/17.
 */
@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts; //these are all the posts the user created.

    //pattern
    //copy constructor - an alternative to clone
    public User(User user) {
        id = user.id;
        username = user.password;
        password = user.password;
        email = user.email;
        posts = user.posts;

    }
    public User(){

    }

    private long getId(){ return id; }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}

