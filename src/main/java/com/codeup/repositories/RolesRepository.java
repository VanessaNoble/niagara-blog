

/**
 * Created by vanessamnoble on 2/13/17.
 */
// SQL - Structured Query Lang - tables
//HQL - Hibernate Query Lang - obj - entities

    
package com.codeup.repositories;

import com.codeup.models.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesRepository extends CrudRepository<UserRole, Long> {

    // SQL -> Structured Query Language -> tables
    // HQL -> Hibernate Query Language -> objects -> entities

    @Query("select ur.role from UserRole ur, User u where u.username=?1 and ur.userId = u.id")
    public List<String> ofUserWith(String username);
}

