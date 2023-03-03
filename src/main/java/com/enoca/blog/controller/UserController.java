package com.enoca.blog.controller;

import com.enoca.blog.model.User;
import com.enoca.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value="/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        return ResponseEntity.ok(userService.create(user));
    }
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        userService.delete(id);
        return new ResponseEntity(OK);
    }
    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user){
        return ResponseEntity.ok(userService.update(user));
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<User> getById(@PathVariable int id){
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }
}
