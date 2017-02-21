package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.models.User;
import com.codeup.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

@Controller
public class PostsController {
    private PostService service;

    // how do i build the AdsController?
    // resolution
    // -> I need to build the ads service
    //    -> I need to build the ads repository

    // execution
    // repo = new AdsRepository();
    // service = new AdService(repo)
    // controller = new AdsController(service);


    @Autowiredw
    public PostsController(PostService service) {
        this.service = service;
    }

    @GetMapping("/posts")
    public String showAllPosts(Model viewModel) {
        viewModel.addAttribute("posts", Collections.emptyList());

        return "posts/index";
    }

    @GetMapping("/posts.json")
    public @ResponseBody List<Post> retrieveAllAds() {
        return service.all();
    }

    @GetMapping("/posts/{id}")
    public String showOnePost(@PathVariable int id, Model viewModel) {
        viewModel.addAttribute("post", service.findOnePost(id));

        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreatePostForm(@ModelAttribute Post post, Model viewModel) {
        viewModel.addAttribute("post", post;
        return "posts/create";
    }

    @Value("${uploads}")
    private String uploadsPath;

    @PostMapping("/posts/create")
    public String savePost(
            @Valid Post post, // it calls @ModelAttribute first
            Errors validation,
            Model viewModel,
            @RequestParam(name = "image_file") MultipartFile uploadedFile
    ) {
        if (validation.hasErrors()) {
            viewModel.addAttribute("errors", validation);
            viewModel.addAttribute("post", post);
            return "posts/create";
        }
        // unix based : mac, linux -> the folder for temporary files is always /tmp -> kljsah12312
        String filename = uploadedFile.getOriginalFilename();
        String filepath = Paths.get(uploadsPath, filename).toString();
        File destinationFile = new File(filepath);
        try {
            uploadedFile.transferTo(destinationFile); // it will move the file in this step
        } catch (IOException e) {
            e.printStackTrace();
        }

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        post.setImage(filename);
        service.save(post);

        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditPostForm(@PathVariable int id, Model viewModel) {
        viewModel.addAttribute("post", service.findOnePost(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@ModelAttribute Post post, Model viewModel) {
        service.update(post);
        viewModel.addAttribute("post", post);
        return "redirect:/posts";
    }
}




