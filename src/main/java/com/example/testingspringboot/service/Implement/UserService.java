package com.example.testingspringboot.service.Implement;

import com.example.testingspringboot.Repository.UserRepository;
import com.example.testingspringboot.entities.User;
import com.example.testingspringboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(long id) {
        return Optional.empty();
    }


    public Optional<User> findUserById(int id) {
        return userRepository.findById(id);
    }

    public User findByUserName(String userName) {

        User user=userRepository.findByUserName(userName);
        return user;

    }

    public User saveUser(User newUser) {

        User user=userRepository.save(newUser);
        return user;

    }

    public User updateUser(int id,User user) {

        Optional<User> retrievedUser=userRepository.findById(id);
        if(retrievedUser==null)
            try {
                throw new Exception("User not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        userRepository.save(user);
        return userRepository.findById(id).get();

    }

    public User deleteUser(int userId) {

        Optional<User> retrievedUser=userRepository.findById(userId);
        if(retrievedUser==null)
            try {
                throw new Exception("User not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        userRepository.deleteById(userId);
        return retrievedUser.get();



    }


}
