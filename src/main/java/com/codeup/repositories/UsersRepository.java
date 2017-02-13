package com.codeup.repositories;


import com.codeup.models.User; ///?
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vanessamnoble on 2/13/17.
 */
@Repository
public interface UsersRepository extends CrudRepository<User, Long> {

    public User findByUsername(String username);

}
