package com.example.testingspringboot.service.Implement;


import com.example.testingspringboot.Repository.UserRepository;
import com.example.testingspringboot.entities.User;
import com.example.testingspringboot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);

    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public List<User> getListUser(long id) {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User editVideo(User user) {
        return null;
    }

    @Override
    public User updateClassRoom(User user) {
        return null;
    }

    @Override
    public User editEmployee(User user) {
        return null;
    }

    @Override
    public List<User> listAll(String keyword) {
        return null;
    }
}
