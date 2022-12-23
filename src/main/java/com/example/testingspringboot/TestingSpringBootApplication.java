package com.example.testingspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestingSpringBootApplication {
//    @Autowired
//    UserRepository userRepository;
//    LoginRepository loginRepository;
//    @PostConstruct
//    public void pupulate(){
//      //  List<User> users = new List<User>(Arrays.asList(1, "kiri", "email", "password", TRUE, "createDate", "updateDate", "user", TRUE));
//
//       // List<User> users = Arrays.asList(1,"kiri", "email", "password", TRUE, "createDate", "updateDate", "user", TRUE);
//        List<Login> users =new ArrayList<Login>();
//        users.add(new Login(1L, "kiri", "email", "password"));
//        loginRepository.saveAll(users);
//
//
//
//
//
//
//    }



    public static void main(String[] args) {
        SpringApplication.run(TestingSpringBootApplication.class, args);
    }

}
