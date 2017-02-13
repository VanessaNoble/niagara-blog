package com.codeup.models;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
/**
 * Created by vanessamnoble on 2/8/17.
 */
@Entity
@Table(name="posts")

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 2000)
    private String description;
    @ManyToOne
    @JoinColumn (name = "user_id") //define at the table level
    private User user;  //owner, author

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Post(){

    }


}



