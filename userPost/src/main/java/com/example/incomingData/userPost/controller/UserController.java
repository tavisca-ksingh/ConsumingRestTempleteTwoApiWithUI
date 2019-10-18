package com.example.incomingData.userPost.controller;

import com.example.incomingData.userPost.DAO.UserDao;
import com.example.incomingData.userPost.model.Login;
import com.example.incomingData.userPost.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;


@RestController
@EnableWebMvc
public class UserController {
    @Autowired
    UserDao userDao;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/greeting")
    public ModelAndView greeting(@RequestParam(name= "name", required=false ,defaultValue = "Hakuna Matata") String name) {
        ModelAndView model = new ModelAndView("greeting");
        model.addObject("name", name);
        return model;
    }

    @GetMapping("/signup")
    public ModelAndView registration(@RequestBody Login login){
       ModelAndView model = new ModelAndView("signup");
    return model;
    }


    @PostMapping("/registerProcess")
    public ModelAndView registration(HttpServletRequest request, @ModelAttribute("user") Users user){
        System.out.println(userDao.createUser(user));
        ModelAndView model = new ModelAndView("login");
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login", new Login());
        return mav;
    }

@GetMapping("/users")
public List<Object> getUsers(){
        String url = "http://localhost:9099/userlist";
        Object [] objects = restTemplate.getForObject(url, Object[].class);
        return Arrays.asList(objects);
}

@RequestMapping(value = "loginprocess", method = RequestMethod.POST)
    public Users loginprocess(@ModelAttribute("login") Login login){
    System.out.println(login);
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    HttpEntity<Login> entity = new HttpEntity<Login>(login,headers);
       return restTemplate.exchange("http://localhost:9099/login"
        , HttpMethod.POST, entity, Users.class).getBody();
    }
}

