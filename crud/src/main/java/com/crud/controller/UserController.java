package com.crud.controller;

import com.crud.entities.User;
import com.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/save")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User addUser = userService.addUser(user);
        return new ResponseEntity<User>(addUser, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = userService.findAllUser();
        return new ResponseEntity<List<User>>(allUser,HttpStatus.OK);
    }

    @GetMapping({"id"})
    public ResponseEntity<User> getUserId(@PathVariable Long id){
        User userById = userService.getUserById(id);
        return new ResponseEntity<User>(userById,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);

    }


}
