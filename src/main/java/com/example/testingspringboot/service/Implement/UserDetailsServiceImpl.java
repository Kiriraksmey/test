//package com.example.testingspringboot.service.Implement;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.example.testingspringboot.Repository.UserRepository;
//import com.example.testingspringboot.entities.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//
//
//    @Override
//    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
//
//        User user=userRepository.findByUserName(name);
//
////		System.out.println("inside impl "+user);
//
//        if(user==null) {
//            System.out.println("exception thrown");
//            throw new UsernameNotFoundException(name + "not found");
//        }
//        return (UserDetails) new UserDetailsServiceImpl();
//    }
//}
