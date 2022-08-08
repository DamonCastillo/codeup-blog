package com.codeup.springblog.controllers;

import com.codeup.springblog.dao.PostRepository;
import com.codeup.springblog.dao.UserRepository;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.services.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final EmailService emailService;
    private PostRepository postsDao;
    @Value("${spring.mail.from}")
    private UserRepository usersDao;
    private String from;

    public PostController(PostRepository postsDao, UserRepository usersDao, EmailService emailService) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
        this.emailService = emailService;
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


    @GetMapping("/posts/create")
    public String showCreatePostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }
    @RequestMapping(path = "/post/{name}", method = RequestMethod.GET)
    public String helloToYou(@PathVariable String name, Model model) {
        System.out.println(from);
        model.addAttribute("name", name);
        emailService.prepareAndSend(usersDao.findByUsername(name), "I just emailed to say Hi!", "How are you doing?");
        return "hello";
    }

    @PostMapping ("/posts/create")
    public String createPost(@ModelAttribute Post post){
       postsDao.save(post);
        return "redirect:/posts";
    }
    @GetMapping("/posts/{id}/edit")
    public String editPost(Model model, @PathVariable long id){
        model.addAttribute("post", postsDao.getById(id));
        return "posts/create";
    }
}