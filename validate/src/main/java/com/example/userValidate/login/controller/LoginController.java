package com.example.userValidate.login.controller;


import com.example.userValidate.login.DAO.LoginDao;
import com.example.userValidate.login.model.Login;
import com.example.userValidate.login.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@EnableWebMvc
public class LoginController {

    @Autowired
    LoginDao loginDao;

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView model = new ModelAndView("login");
        return model;
    }


    @GetMapping("/userlist")
    public List<Users> userlist(){
        return loginDao.reteriveAllItems();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Users loginProcess(@RequestBody Login login) {
        ModelAndView mav = null;
       String name = login.getUsername();
       String pass = login.getPassword();
        System.out.println(name + " " + pass);
        Users user=loginDao.findUser(name,pass) ;
        if (null != login) {
            mav = new ModelAndView("greeting");
            mav.addObject("name", name);
        } else {
            mav = new ModelAndView("login");
            mav.addObject("name", "Username or Password is wrong!!");
        }
        return user ;
    }


@RequestMapping(value = "/employees", method = RequestMethod.POST)
public String createEmployee(@RequestBody Users users)
{
    System.out.println(users);
    return users.toString();
}


}
