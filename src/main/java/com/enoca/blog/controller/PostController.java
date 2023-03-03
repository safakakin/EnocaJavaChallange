package com.enoca.blog.controller;

import com.enoca.blog.model.Post;
import com.enoca.blog.model.User;
import com.enoca.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value="/posts")
public class PostController {
    private final PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping
    public ResponseEntity<Post> create(@RequestBody Post post){
        return ResponseEntity.ok(postService.create(post));
    }
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        postService.delete(id);
        return new ResponseEntity(OK);
    }
    @PutMapping
    public ResponseEntity<Post> update(@RequestBody Post post){
        return ResponseEntity.ok(postService.update(post));
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<Post> getById(@PathVariable int id){
        return ResponseEntity.ok(postService.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<Post>> getAll(){
        return ResponseEntity.ok(postService.getAll());
    }
}
