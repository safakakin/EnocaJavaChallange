package com.enoca.blog.repository;

import com.enoca.blog.model.Post;
import com.enoca.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    //Post findByPostId(Integer id);
}
