package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.services.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vanessamnoble on 2/7/17.
 */
@Controller
public class PostsController {
    @Autowired  //    property injection
            PostSvc postSvc;

    @GetMapping("/posts")
    public String viewAllPosts(Model viewModel) {
        // array list with several post objects
        List<Post> posts = postSvc.findAllPosts();

        // pass the list to the view (through a view model)
        viewModel.addAttribute("posts", posts);
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewSinglePost(@PathVariable long id, Model model) {
//        Inside the method that shows an individual post, create a new post object and pass it to the view.
        Post post = postSvc.findOne(id);
        model.addAttribute("post", post);
        return "/posts/show"; // show.html
    }

    @GetMapping("/posts/create")
    public String view(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post, Model model) {
        postSvc.save(post);
        model.addAttribute("post", post);
        return "posts/create";
    }
    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable int id, @ModelAttribute Post post, Model model) {
        model.addAttribute("post", postSvc.findOne(id));
        return "posts/edit";
    }
}