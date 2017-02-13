package com.codeup.repositories;

import com.codeup.models.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by vanessamnoble on 2/13/17.
 */
// SQL - Structured Query Lang - tables
//HQL - Hibernate Query Lang - obj - entities

    
public interface RolesRepository extends CrudRepository<UserRole, Long> {
    @Query("select ur.role from UserRole ur, User u where u.where u.username=?1 and ur.userId = u.id")
    public List<String> ofUserWith(String username);
}
