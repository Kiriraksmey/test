package com.example.testingspringboot.service.Implement;


import com.example.testingspringboot.Repository.UserRepository;
import com.example.testingspringboot.entities.User;
import com.example.testingspringboot.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
