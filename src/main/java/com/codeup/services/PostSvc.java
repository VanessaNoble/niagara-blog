//package com.codeup.services;
//
//import com.codeup.models.Post;
//import  com.codeup.repositories.PostsRepository;
//import com.sun.tools.doclets.formats.html.markup.HtmlStyle;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by vanessamnoble on 2/8/17.
// * finding a post (retrieving an individual post object)
// retrieving all the posts
// */
//@Service("postsSvc")
//public class PostSvc {
//    private List<Post> posts = new ArrayList<>();
//    private PostsRepository repository;
//
//    @Autowired
//    public PostSvc(PostsRepository repository) {
//        this.repository = repository;
//    }
//
//    public PostSvc() {
//        createPosts();
//    }
//
//    private void createPosts() {
//        for (int i = 0; i < 100; i++) {
//            save(new Post(i + 1, "title " + (i + 1), "Some body content" + (i + 2)));
//        }
//    }
//
//    public void save(Post post) {
//        repository.save(post);
//    }
//    //    public Post save(Post post) {
////        post.setId(posts.size() + 1);
////        posts.add(post);
////        return post;
////    }
//
//    public List<Post> findAll() {
//        // Interval -> List (casting int)yes
//        return (List<Post>) repository.findAll();
//    }
//
//    public Post findOne(long id) {
//        return repository.findOne(id);
//    }
//
//    public void update(Post post) {
//        repository.save(post); //update
//        //posts.set(post.getId() -1, post);
//    }
//
//
//    public void delete(Post one) {
//        repository.delete(one);
//    }
//
////    public Post[] findwhereTitleLike(Post title) {
////        repository.post(title);
////    }
//}



