package com.example.testingspringboot.config;

import com.example.testingspringboot.Repository.UserRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userSecurity")
public class UserSecurity {
    @Autowired
    UserRepository userRepository;

    public boolean hasUserId(Authentication authentication, Long id) {

        long userID=userRepository.findByUserName(authentication.g);
//		System.out.println(userId+"  "+userID);
        if(userID==id)
            return true;

        return false;

    }
}
