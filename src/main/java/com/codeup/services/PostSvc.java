package com.codeup.services;

import com.codeup.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vanessamnoble on 2/8/17.
 * finding a post (retrieving an individual post object)
 retrieving all the posts
 */
@Service("postsSvc")
public class PostSvc {
    private List<Post> posts = new ArrayList<>();

    public PostSvc() {
        createPosts();
    }

    private void createPosts() {
        for (int i = 0; i < 100; i++) {
            save(new Post(i+1, "title " + (i + 1), "Some body content" + (i + 2)));
        }
    }
    public Post save(Post post) {
        post.setId(posts.size()+1);
        posts.add(post);
        return post;
    }
    //    public Post save(Post post) {
//        post.setId(posts.size() + 1);
//        posts.add(post);
//        return post;
//    }
    public List<Post> findAll() {
        return posts;
    }
    public Post findOne(long id) {
        return  posts.get((int) (id -1));
    }
    public List<Post> findAllPosts(){
        return posts;
    }
}




