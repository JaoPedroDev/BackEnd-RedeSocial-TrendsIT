package com.jaopedrodev.redesocial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaopedrodev.redesocial.model.PostModel;
import com.jaopedrodev.redesocial.service.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostModel> findAll() {
        return postService.findAll();
    }
}
