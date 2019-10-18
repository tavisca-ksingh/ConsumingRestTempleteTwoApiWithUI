package com.example.userValidate.login.DAO;

import com.example.userValidate.login.model.Users;
import com.example.userValidate.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Component
public class LoginDao {

    @Autowired
    private UserRepository serviceRepository;

    @Autowired
    EntityManager entityManager;

    public List<Users> reteriveAllItems(){
        return serviceRepository.findAll();
    }


    public Users findUser(String name , String pass) {
        Users user = null;

         Query query =entityManager.createQuery("SELECT u FROM Users u WHERE u.username LIKE:name AND u.password LIKE:pass");
        query.setParameter("name", name);
        query.setParameter("pass", pass);
        try {
            user = (Users) query.getSingleResult();
        } catch (Exception e) {

        }
        return user;
    }
}
