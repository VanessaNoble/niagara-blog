package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



/**
 * Created by vanessamnoble on 2/7/17.
 */


@Controller
public class PostsController {
    @Autowired
    PostsRepository service;

    public PostsController(PostsRepository service){
        this.service = service;
    }

    @GetMapping("/posts")
    public String index(Model m) {
        m.addAttribute("posts", service.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String post(@PathVariable long id, Model m) {
        m.addAttribute("post", service.findOne(id));
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String view(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post, Model model) {
//        User user = new User(post);
//        user.setId(2);
//        post.setUser(user);
//        service.save(post);
        service.save(post);
        model.addAttribute("post", post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable Long id, @ModelAttribute Post post, Model model) {
        model.addAttribute("post", service.findOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@ModelAttribute Post post) {
        service.delete(service.findOne(post.getId()));
        return "redirect:/posts";
    }

}



