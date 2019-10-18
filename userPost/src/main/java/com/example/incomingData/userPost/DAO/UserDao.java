package com.example.incomingData.userPost.DAO;


import com.example.incomingData.userPost.model.Users;
import com.example.incomingData.userPost.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;

@Component
public class UserDao {


    @Autowired
    UserRepository userRepository;


    public Users createUser(@RequestBody Users user) {
        return userRepository.save(user);
    }


}
