

/**
 * Created by vanessamnoble on 2/13/17.
 */
package com.codeup.repositories;


import com.codeup.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<User, Integer> {
    // select * from user where username = ?
    // automagic
    public User findByUsername(String username);
}

