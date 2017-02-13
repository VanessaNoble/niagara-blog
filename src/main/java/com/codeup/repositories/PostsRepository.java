package com.codeup.repositories;

import com.codeup.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by vanessamnoble on 2/9/17.
 */

//insert -> table name, values, columns
//select -> table, columns, values
//update -> table, columns, values
//delete -> table, values

@Repository
public interface PostsRepository extends CrudRepository<Post, Long> {

}
