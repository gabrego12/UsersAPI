package com.gabrego.usersapi.controller;

import com.gabrego.usersapi.entity.User;
import com.gabrego.usersapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Indiciamos que es un controlador rest
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@RequestMapping("/usersapi") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/usersapi/
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId){
        User user = userService.findById(userId);

        if(user == null) {
            return new User();
        }
        //retornará al usuario con id pasado en la url
        return user;
    }

    @GetMapping("/users/email/{userEmail}")
    public User getUserByEmail(@PathVariable String userEmail){
        User user = userService.findByEmail(userEmail);

        if(user == null) {
            return new User();
        }
        //retornará al usuario con id pasado en la url
        return user;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        user.setId(0);

        User user1 = userService.findByEmail(user.getEmail());

        if (user1 == null) {
            userService.save(user);
        } else {
            return new User();
        }

        return user;

    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {

        userService.save(user);

        //este metodo actualizará al usuario enviado

        return user;
    }

    @DeleteMapping("users/{userId}")
    public int deleteUser(@PathVariable int userId) {

        User user = userService.findById(userId);

        if(user == null) {
            return 0;
        }

        return userService.deleteById(userId);
    }

    
}
