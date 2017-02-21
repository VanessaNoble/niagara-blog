package com.codeup.models;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by vanessamnoble on 2/15/17.
 */
@Entity
@Table(name="ads")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NotBlank(message = "Title cannot be empty")
    private String title;

    @Column(length = 2000, nullable = false)
    @NotBlank(message = "Descriptions cannot be empty")
    @Size(min = 5, message = "Description must have at least 5 characters")
    private String description;

    @Column
    private String image;

    // will define your foreign key
    // i will use a convention  `the_other_table_name_id`
    @ManyToOne
    @JoinColumn (name = "user_id")  // define at the table level
    @JsonManagedReference
    private User user;  // owner, author

    public Ad(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Ad() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

