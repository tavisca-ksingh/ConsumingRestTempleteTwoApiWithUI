package com.example.userValidate.login.repository;
import com.example.userValidate.login.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {
}
