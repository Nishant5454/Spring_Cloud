package com.example.UserService.Service;

import com.example.UserService.Entity.User;
import com.example.UserService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User saveUser(User user){
        return  userRepository.save(user);
    }
    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}
