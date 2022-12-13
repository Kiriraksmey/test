package com.example.testingspringboot.controller.admin;

import com.example.testingspringboot.entities.User;
import com.example.testingspringboot.service.IUserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/v1")
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class UserRestController {
    @Autowired
    IUserService userService;

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
    @GetMapping("/users")
    public List<User> getAllUsers(Authentication authentication) {

        return userService.findAllUsers();

    }

    @PostMapping("/users")
    public ResponseEntity<User> saveusers(@RequestBody User newUser, Authentication auth) {
        System.out.println(newUser.getName()+"  "+auth.name());
        return ResponseEntity.status(HttpStatus.CREATED).body((userService.saveUser(newUser)));

    }

    @PreAuthorize("@userSecurity.hasUserId(authentication,#userId)")
    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") int userId, Authentication authentication) {
        System.out.println("Inside getuserbyid method");
        return ResponseEntity.ok().body(userService.findUserById(userId).get());

    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") int UserId,@RequestBody User newUser) {
        return ResponseEntity.ok().body(userService.updateUser(UserId,newUser));

    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable("userId") int UserId) {
        userService.deleteUser(UserId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @GetMapping("/users/search")
    @PostAuthorize("returnObject.body.userName==authenticated.user")
    public ResponseEntity<User> userDetails(Authentication authentication, @RequestParam("cname") String cName) throws Exception {
        System.out.println(authentication.name().toString());
        User User=userService.findByUserName(cName);
        if(User==null) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return ResponseEntity.ok().body(User);

    }
}
