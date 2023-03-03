package com.enoca.blog.service;

import com.enoca.blog.model.Post;
import com.enoca.blog.model.User;
import com.enoca.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post create(Post post){
        return postRepository.save(post);
    }
    public void delete(int id){
        postRepository.delete(postRepository.findById(id).orElseThrow());
    }
    public Post update(Post post){
        Post updatedPost=postRepository.findById(post.getId()).orElseThrow();
        updatedPost.setNo(post.getNo());
        updatedPost.setTitle(post.getTitle());
        updatedPost.setContent(post.getContent());
        return updatedPost;
    }
    public List<Post> getAll(){
        return postRepository.findAll();
    }
    public Post getById(int id){
        return postRepository.findById(id).orElseThrow();
    }
}
