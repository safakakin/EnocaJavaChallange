package com.enoca.blog.service;

import com.enoca.blog.model.User;
import com.enoca.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User create(User user){
        return userRepository.save(user);
    }
    public void delete(int id){
        userRepository.delete(userRepository.findById(id).orElseThrow());
    }
    public User update(User user){
        User updatedUser=userRepository.findById(user.getId()).orElseThrow();
        updatedUser.setName(user.getName());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setEmail(user.getEmail());
        return updatedUser;
    }
    public List<User> getAll(){
        return userRepository.findAll();
    }
    public User getById(int id){
        return userRepository.findById(id).orElseThrow();
    }
}
