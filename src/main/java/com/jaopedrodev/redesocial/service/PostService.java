package com.jaopedrodev.redesocial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.jaopedrodev.redesocial.enums.UserRole;
import com.jaopedrodev.redesocial.model.PostModel;
import com.jaopedrodev.redesocial.model.UserModel;
import com.jaopedrodev.redesocial.repository.PostRepository;
import com.jaopedrodev.redesocial.repository.UserRepository;

import org.springframework.http.HttpStatus;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    public List<PostModel> findAll() {
        return postRepository.findAll();
    }

    public PostModel findById(Long id) {
        return postRepository.findById(id).get();
    }

    public PostModel savePost(PostModel post) {
        return postRepository.save(post);
    }

    public boolean deletePost(Long postId, Long userId) {
        Optional<PostModel> postOptional = postRepository.findById(postId);

        if (postOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
        }

        PostModel post = postOptional.get();

        UserModel user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        if (post.getAuthor().getId().equals(user.getId()) || user.getRole().equals(UserRole.ADMIN)) {
            postRepository.delete(post);
            return true;
        }
        return false;
    }
}
