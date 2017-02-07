package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by vanessamnoble on 2/7/17.
 */
@Controller
public class PostsController {
    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public String postIndex() {

        return "<h1>Welcome to the posts index page!!!!</h1>";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String postID(@PathVariable String id) {

        return "<h1>Hey " + id + "! , view an individual post </h1>";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String createForm() {

        return "<h1> view the form for creating a post </h1>";
    }

//    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
//    @ResponseBody
//    public String postCreate() {
//
//        return "<h1> create a new post </h1>";
//    }
}
