package com.example.incomingData.userPost.repository;


import com.example.incomingData.userPost.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {

}
