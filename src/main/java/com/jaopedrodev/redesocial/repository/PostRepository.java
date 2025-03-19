package com.jaopedrodev.redesocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaopedrodev.redesocial.model.PostModel;
import com.jaopedrodev.redesocial.model.UserModel;

import java.util.List;

public interface PostRepository extends JpaRepository<PostModel, Long> {
    List<PostModel> findByAuthor(UserModel author);
}
