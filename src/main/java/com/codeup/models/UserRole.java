package com.codeup.models;

import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

/**
 * Created by vanessamnoble on 2/13/17.
 */
@Entity
@Table(name = "user_roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "role")
    private String role;
}


