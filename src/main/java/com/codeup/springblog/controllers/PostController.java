package com.codeup.springblog.controllers;

import com.codeup.springblog.dao.PostRepository;
import com.codeup.springblog.dao.UserRepository;
import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postsDao;
    private final UserRepository userDao;

    public PostController(PostRepository postsDao , UserRepository userDao) {
        this.postsDao = postsDao;
        this.userDao = userDao;
    }
    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String viewAllPosts(Model model) {
        model.addAttribute("posts", postsDao.findAll());
        return "/posts/index";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public String viewIndividualPosts(@PathVariable long id, Model model) {
        model.addAttribute("singlePost", postsDao.getById(id));
        return "/posts/show";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    public String viewCreatePostForm() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String savePost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
        postsDao.save(new Post(title, body));
        return "redirect:/posts";
    }
}
